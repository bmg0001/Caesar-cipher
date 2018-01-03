package kr.krl.enc;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Crypto cry = new Crypto("");
		int brk = 0;
		while(true) {
			int menuid=0;
			do {
				System.out.println("---------- 암호화 프로그램 -----------");
				System.out.println("1. 문자열 암호화");
				System.out.println("2. 문자열 복호화");
				System.out.println("3. 종료");
				System.out.print(">> ");
				menuid = sc.nextInt();
			}while(menuid<1 || menuid > 3);
			
			switch(menuid) {
			case 1:
				System.out.print("암호화 할 문자열을 입력하세요 > ");
				sc.nextLine();
				String data = sc.nextLine();
				System.out.print("Key를 입력하세요(정수) > ");
				int Key = sc.nextInt();
				
				cry.Setup(data);
				String ENC = cry.ENC(Key);
				
				System.out.println("-------------\n암호화 > "+ENC+"\n-------------\n아무키나 누르면 초기화면으로 이동합니다.");
				sc.nextLine();
				sc.nextLine();
				break;
			case 2:
				System.out.print("복호화 할 문자열을 입력하세요 > ");
				sc.nextLine();
				data = sc.nextLine();
				System.out.print("Key를 입력하세요(정수) > ");
				Key = sc.nextInt();
				
				cry.Setup(data);
				String DEC = cry.DEC(Key);
				
				System.out.println("-------------\n복호화 > "+DEC+"\n-------------\n아무키나 누르면 초기화면으로 이동합니다.");
				sc.nextLine();
				sc.nextLine();
				break;
			case 3:
				brk = 1;
				break;
			}
			if(brk == 1) break;
		}
	}

}
class Crypto{
	String Data;
	public Crypto(String Data){
		this.Data = Data;
	}
	public void Setup(String Data) {
		this.Data = Data;
	}
	public String ENC(int N){
		String Encode = new String();
		for(int i=0; i<this.Data.length(); i++) {
			char c = this.Data.charAt(i);
			if((int)c >= (int)'A' && (int)'Z' >= (int)c) {
				int tmp = (int)c-'A';
				if(tmp+N < 0) {
					tmp += 26;
				}
				tmp = (tmp+N)%26;
				tmp += (int)'A';
				Encode = Encode + (char)tmp;
			}
			else if((int)c >= (int)'a' && (int)'z' >= (int)c) {
				int tmp = (int)c-'a';
				if(tmp+N < 0) {
					tmp += 26;
				}
				tmp = (tmp+N)%26;
				tmp += (int)'a';
				Encode = Encode + (char)tmp;
			}
			else if((int)c >= (int)'0' && (int)'9' >= (int)c) {
				int tmp = (int)c-'0';
				if(tmp+N < 0) {
					tmp += 10;
				}
				tmp = (tmp+N)%10;
				tmp += (int)'0';
				Encode = Encode + (char)tmp;
			}
			else {
				Encode = Encode + (char)c;
			}
		}
		return Encode;
	}
	public String DEC(int N){
		String Decode = new String();
		N =-N;
		for(int i=0; i<this.Data.length(); i++) {
			char c = this.Data.charAt(i);
			if((int)c >= (int)'A' && (int)'Z' >= (int)c) {
				int tmp = (int)c-(int)'A';
				if(tmp+N < 0) {
					tmp += 26;
				}
				tmp = (tmp+N)%26;
				tmp += (int)'A';
				Decode = Decode + (char)tmp;
			}
			else if((int)c >= (int)'a' && (int)'z' >= (int)c) {
				int tmp = (int)c-(int)'a';
				if(tmp+N < 0) {
					tmp += 26;
				}
				tmp = (tmp+N)%26;
				tmp += (int)'a';
				Decode = Decode + (char)tmp;
			}else if((int)c >= (int)'0' && (int)'9' >= (int)c) {
				int tmp = (int)c-'0';
				if(tmp+N < 0) {
					tmp += 10;
				}
				tmp = (tmp+N)%10;
				tmp += (int)'0';
				Decode = Decode + (char)tmp;
			}else {
				Decode = Decode + (char)c;
			}
		}
		return Decode;
	}
}