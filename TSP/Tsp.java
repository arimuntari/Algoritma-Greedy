import java.util.Scanner;
class Tsp{
	public static void main(String[] args){
		int jml, start = 0, temp = 9999, tempstart= 0, total = 0;
		char mulai;
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukkan Jumlah titik : ");
		jml = scan.nextInt();
		char[] node = new char[jml];
		int[][] data = new int[jml][jml];	
		char[] pathhasil = new char[jml-1];
		int[] hasilnilai = new int[jml-1]; 
		for(int i=0; i<jml; i++){
			System.out.print("Masukkan Titik "+(i+1)+" : ");
			node[i] = scan.next().charAt(0);
		}
		for(int i= 0 ; i< jml; i++){
			for(int j= 0 ; j< jml; j++){
				if(node[i] != node[j]){
					System.out.print("Masukkan Jarak dari "+node[i]+" ke "+node[j]+": ");
					data[i][j] = scan.nextInt();
				}else{
					System.out.println("Masukkan Jarak dari "+node[i]+" ke "+node[j]+": 0");
					data[i][j] =0;
				}
				
			}
		}
		Tsp tsp = new Tsp();
		tsp.tampilTabel(data, jml, node);
		System.out.print("Masukkan Titik Mulai : ");
		mulai = scan.next().charAt(0);
		for(int i= 0 ; i< jml; i++){
			if(node[i]==mulai){
				start= i;
			}
		}
		for(int i= 0 ; i< jml-1; i++){
			temp =9999;
			
			for(int j= 0 ; j<jml; j++){
				data[j][start]= 9999;
			}
			for(int j= 0 ; j<jml; j++){
				if(start != j){
					if(data[start][j] < temp ){
						temp = data[start][j];
						tempstart = j;
						//System.out.println(temp+" "+start);
					}
				}
			}
			 total = total+temp;
			pathhasil[i] = node[tempstart];
			hasilnilai[i] = temp;
			start = tempstart;
		}
		System.out.print("\nHASILNYA ADALAH : "+mulai);
		for(int i=0; i<jml-1;i++){
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