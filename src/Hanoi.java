import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Hanoi {
	

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("data/Input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/Output.txt"));
        int i=0;
        try {
        	int tries=Integer.parseInt(bufferedReader.readLine());
        	int n=0;
        	
        	while(i<tries) {
				n=Integer.parseInt(bufferedReader.readLine());
				int[] b= {n,0,0};
				bufferedWriter.write(n+" "+0+" "+0+"\n");
				hanoi(n,0,2,1,bufferedWriter,b);
				bufferedWriter.write("\n");
				i++;
			}
        	bufferedReader.close();
        	bufferedWriter.close();
        }
		catch(NumberFormatException|IOException a){
			System.out.println("There was an error at the time of running the application");
			System.out.println("Number Format Exception");
		}
		
        
	}
	
	public static void hanoi(int n, int start, int last, int aux, BufferedWriter a, int[] b) throws IOException {
		
					switch(n){
					case 1:
						b[start]--;
						b[last]++;
						a.write(b[0]+" "+b[1]+" "+b[2]+"\n");
						break;
		
						default:
							hanoi(n-1, start, aux, last, a, b);
							b[start]--;
							b[last]++;
							a.write(b[0]+" "+b[1]+" "+b[2]+"\n");
							hanoi(n-1, aux, last, start,a, b);
			
		}
	}

}
