import java.util.Scanner;
class Shortestpath{
	public static void main(String[] args){
		int jml, counter=0, start = -1, end = -1,hapus = -1, temp = 9999, tempstart= 0, total = 0;
		char mulai, akhir;
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukkan Jumlah titik : ");
		jml = scan.nextInt();
		char[] node = new char[jml];
		int[][] data = new int[jml][jml];	
		char[] pathhasil = new char[1000];
		for(int i=0; i<jml; i++){
			System.out.print("Masukkan Titik "+(i+1)+" : ");
			node[i] = scan.next().charAt(0);
		}
		for(int i= 0 ; i< jml; i++){
			for(int j= i ; j< jml; j++){
				if(node[i] != node[j]){
					System.out.print("Masukkan Jarak dari "+node[i]+" ke "+node[j]+": ");
						data[i][j] = scan.nextInt();
						data[j][i] = data[i][j];
					}
			}
		}
		Shortestpath tsp = new Shortestpath();
		tsp.tampilTabel(data, jml, node);
		System.out.print("Masukkan Titik Mulai : ");
		mulai = scan.next().charAt(0);
		for(int i= 0 ; i< jml; i++){
			if(node[i]==mulai){
				start= i;
			}
		}
		System.out.print("Masukkan Titik Akhir : ");
		akhir = scan.next().charAt(0);
		for(int i= 0 ; i< jml; i++){
			if(node[i]==akhir){
				end= i;
			}
		}
		if(start >= 0  && end >= 0  ){
			while(start != end){
			temp =9999;
			hapus = start;
				for(int j= 0 ; j<jml; j++){
					if(data[start][j] != 0){
						if(data[start][j] < temp ){
							temp = data[start][j];
							tempstart = j;
						}
					}
				}
				total = total+temp;
				pathhasil[counter] = node[tempstart];
				start = tempstart;
				for(int j= 0 ; j<jml; j++){
					data[j][hapus]= 0;
					data[hapus][j]= 0;
				}
				counter++;
			}
		}
		System.out.print("\nHASILNYA ADALAH : "+mulai);
		for(int i=0; i<counter;i++){
			System.out.print("->"+pathhasil[i]);
		}
		System.out.print("= "+total+"\n");
	}
	public void tampilTabel(int[][] nilai, int n, char[] node){
		System.out.println("\n");
		for(int i=-1;i<n; i++){
				if(i==-1){
					System.out.print("");
				}else{
					System.out.print(""+node[i]+"");
				}
			for(int j=0;j<n; j++){
				if(i==-1){
					System.out.print("\t"+node[j]);
				}else{
					System.out.print("\t"+nilai[i][j]);
				}
			}
			System.out.println();
		}
	}
}