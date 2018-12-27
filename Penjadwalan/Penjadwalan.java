import java.util.Scanner;
class Penjadwalan {
	public static void main(String[] args){		
		int n, total=0;
		int[][] nilai = new int[100][100];
		Scanner inputan = new Scanner(System.in);
		System.out.print("PROGRAM PENJADWALAN MENGGUNAKAN GREEDY\n\n");
		System.out.print("Input banyak Pekerja  dan Pekerjaan : ");
		n = inputan.nextInt();
		for(int i=0;i<n; i++){
			for(int j=0;j<n; j++){
				System.out.print("Masukkan Nilai data[W"+(i+1)+"][P"+(j+1)+"]: ");
				nilai[i][j] = inputan.nextInt();
			}
		}
		Penjadwalan jadwal = new Penjadwalan();
		jadwal.tampilTabel(nilai, n);
		jadwal.tesTotal(nilai, n);
	}
	public void tesTotal(int[][] nilai, int n){
		int  temp=9999999, total=0, ind=0;
		String hasiltext = "", text= "";
		for(int i=0; i<n;i++){
			temp=9999999;
			for(int j=0; j<n;j++){
				if(nilai[j][i] < temp ){
					text= "";
					text = text + "P"+(i+1)+" Dikerjakan Oleh W"+(j+1)+" Nilai = "+nilai[j][i];
					ind = j;
					temp = nilai[j][i];
				}
			}
			for(int j=0;j<n;j++){
				nilai[ind][j] = 9999999;
			}
			hasiltext = hasiltext+text+"\n";
			total += temp;
		}
		System.out.println(hasiltext);
	}
	public void tampilTabel(int[][] nilai, int n){
		System.out.println("\n");
		for(int i=-1;i<n; i++){
				if(i==-1){
					System.out.print("__|");
				}else{
					System.out.print("W"+(i+1)+"");
				}
			for(int j=0;j<n; j++){
				if(i==-1){
					System.out.print("\tP"+(j+1));
				}else{
					System.out.print("\t"+nilai[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}