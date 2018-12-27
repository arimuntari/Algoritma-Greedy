import java.util.Scanner;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		char abjad[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int[] terbaik = new int[10];
		int jumlahBarang, hargaSementara = 0, beratSementara = 0, tampungHarga = 0, tampungBerat = 0, beratMax, index = -1, bantu = 0;
		
		System.out.println("Program Knapsack Metode Brurefoce\n");
		Scanner inputan = new Scanner(System.in);
		System.out.print("Tentukan jumlah barang yang akan diinput : ");
		jumlahBarang = inputan.nextInt();
		
		int[][] data = new int[jumlahBarang][2];
		
		for( int i = 0; i < jumlahBarang; i++ ){
			System.out.print("\nInput harga barang " + abjad[i] + " : ");
			data[i][0] = inputan.nextInt();
			System.out.print("Input berat barang " + abjad[i] + " : ");
			data[i][1] = inputan.nextInt();
		}
		System.out.print("\nTentukan batas berat maksimum : ");
		beratMax = inputan.nextInt();
		for( int i = 0; i < jumlahBarang; i++ ){
			hargaSementara = 0;
			for( int j = 0; j < jumlahBarang; j++ ){
				if( data[j][0] >= hargaSementara && data[j][0] != -1 ){
					hargaSementara = data[j][0];
					bantu = j;
				}
			}
			beratSementara = beratSementara + data[bantu][1];
			data[bantu][0] = -1;
			if( beratSementara <= beratMax ){
				tampungBerat = beratSementara;
				tampungHarga = tampungHarga + hargaSementara;
				index++;
				terbaik[index] = bantu;
			}else
				beratSementara = beratSementara - data[bantu][1];
		}
		
		System.out.println("\nKombinasi barang dengan total harga maksimal : \n");
		for( int i = 0; i <= index; i++ ){
			System.out.print( abjad[ terbaik[i] ] );
			if( i < index )
				System.out.print(" + ");
		}
		System.out.println("\n\nTotal Berat : " + tampungBerat + "Kg");
		System.out.println("Total Harga : " + tampungHarga);
	}
}