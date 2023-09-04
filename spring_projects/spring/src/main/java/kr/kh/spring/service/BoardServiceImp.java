package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.util.UploadFileUtils;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikeVO;
import kr.kh.spring.vo.MemberVO;
import kr.kh.spring.vo.ViewVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		if(!boardDao.insertBoard(board)) {
			return false;
		}
		if(files == null || files.length == 0) {
			return true;
		}
		uploadFileAndInsert(files, board.getBo_num());
		return true;
	}

	private void uploadFileAndInsert(MultipartFile[] files, int bo_num) {
		if(files == null || files.length == 0) {
			return;
		}
		for(MultipartFile file : files) {
			if(file == null || file.getOriginalFilename().length() == 0) {
				continue;
			}
			try {
				String fi_name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
				FileVO fileVo = new FileVO(bo_num, fi_name, file.getOriginalFilename());
				boardDao.insertFile(fileVo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<BoardVO> selectBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
		
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardCount(cri);
	}

	@Override
	public BoardVO selectBoard(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public void updateViews(Integer bo_num, MemberVO user) {
		if(bo_num == null) {
			return;
		}
		if(user == null) {
			return;
		}
		ViewVO viewcount = boardDao.selectViewcount(bo_num, user);
		if(viewcount == null) {
			boardDao.insertViewCount(bo_num, user);
			boardDao.updateViews(bo_num);
		}		
	}

	@Override
	public List<FileVO> getFileList(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectFileList(bo_num);
	}

	@Override
	public boolean deleteBoard(Integer bo_num, MemberVO user) {
		if(bo_num == null || user == null) {
			return false;
		}
		BoardVO board = boardDao.selectBoard(bo_num);
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		List<FileVO> fileList = board.getFileVoList();
		deleteFile(fileList);
		boardDao.deleteBoard(bo_num);
		return true;
		
	}

	private void deleteFile(List<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0){
			return;
		}
		Integer [] nums = new Integer[fileList.size()];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = fileList.get(i).getFi_num();
		}
		deleteFile(nums);
		
	}

	private void deleteFile(Integer[] delFiles) {
		if(delFiles == null || delFiles.length == 0) {
			return;
		}
		
		for(Integer num : delFiles) {
			if(num == null) {
				continue;
			}
			//첨부파일 정보를 가져옴
			FileVO fileVo = boardDao.selectFile(num);
			if(fileVo == null) {
				continue;
			}
			UploadFileUtils.deleteFile(uploadPath, fileVo.getFi_name());
			//DB에서 제거 
			boardDao.deleteFile(num);
		}
		
	}

	@Override
	public boolean updateBoard(BoardVO board, MultipartFile[] files, Integer[] delFiles, MemberVO user) {
		if(board == null || board.getBo_title()==null || board.getBo_title().length() == 0 ) {
			return false;
		}
		//게시글 정보를 가져옴(로그인한 회원과 작성자가 같은지 확인을 위해) 
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//db에 해당 게시글이 없거나 게시글 작성자와 로그인한 회원이 다른 경우
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		if(!boardDao.updateBoard(board)) {
			return false;
		}
		//첨부파일 업데이트 
		//추가된 첨부파일을 서버에 업로드 및 DB에 추가
		uploadFileAndInsert(files, board.getBo_num());
		
		//삭제된 첨부파일을 서버에서 제거 및 DB에서 제거
		deleteFile(delFiles);
		return true;
	}

	@Override
	public boolean likeBoard(Integer bo_num, MemberVO user, int likeState) {
		if(bo_num == null) {
			return false;
		}
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(likeState == 0) {
			return false;
		}
		LikeVO dbLike = boardDao.selectLike(bo_num, user);
		if(dbLike == null) {
			if(likeState == 1) {
				boardDao.insertLike(bo_num, user, likeState);
				boardDao.updateBoardLikeup(bo_num);	
				return true;
			} else if(likeState == -1)
				boardDao.insertLike(bo_num, user, likeState);
				boardDao.updateBoardLikedown(bo_num);
				return true;
		}
		switch(dbLike.getLi_state()) {
		case 0:
			if(likeState == 1) {
				boardDao.updateLike(dbLike.getLi_num(), likeState);
				boardDao.updateBoardLikeup(bo_num);				
			} else if(likeState == -1) {
				boardDao.updateLike(dbLike.getLi_num(), likeState);
				boardDao.updateBoardLikedown(bo_num);
			}
			break;
		case 1:
			if(likeState == 1) {
				likeState -= 1;
				boardDao.updateLike(dbLike.getLi_num(), likeState);
				boardDao.updateBoardLikeupUndo(bo_num);				
			} else if(likeState == -1) {
				boardDao.updateLike(dbLike.getLi_num(), likeState);
				boardDao.updateBoardLikeupUndo(bo_num);
				boardDao.updateBoardLikedown(bo_num);
			}
			break;
		case -1:
			if(likeState == 1) {
				boardDao.updateLike(dbLike.getLi_num(), likeState);
				boardDao.updateBoardLikedownUndo(bo_num);
				boardDao.updateBoardLikeup(bo_num);	
			} else if(likeState == -1) {
				likeState += 1;
				boardDao.updateLike(dbLike.getLi_num(), likeState);
				boardDao.updateBoardLikedownUndo(bo_num);
			}
			break;
		}
		return true;
	}

	@Override
	public LikeVO searchLike(Integer bo_num, MemberVO user) {
		if(bo_num == null) {
			return null;
		}
		if(user == null || user.getMe_id() == null) {
			return null;
		}
		return boardDao.selectLike(bo_num, user);
	}
}
