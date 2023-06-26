package day19.format;
import java.text.DecimalFormat;
public class DecimalFormatEx {

	public static void main(String[] args) {
		int price = 10000;
		DecimalFormat df = new DecimalFormat("\u00A4###,###");
		String str1 = df.format(price);
		System.out.println(str1);
		
		df = new DecimalFormat("000,000");
		String str2 = df.format(price);
		System.out.println(str2);

	}

}
