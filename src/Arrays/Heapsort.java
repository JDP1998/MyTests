package Arrays;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Arrays.Node;

public class Heapsort {
		// TODO Auto-generated method stub
		public static int [] numbers = new int [10000];
	    public static int levels=0,size=0;
	    public static int counter=0,k,parent,number,position,akt_position=0,akt_number=1,akt_size=0,akt_level=1;
	    public static ArrayList <Node> lst_Nodes = new ArrayList();
	    public static boolean is_sorted=false;
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			long start, end, time;
			start=System.currentTimeMillis();
			File f = new File("C:\\Users\\jportzeh\\Desktop\\Java Dateien\\Numbers.txt");
			if(f.exists()==false) {
				f.createNewFile();
			}
			BufferedReader bReader = new BufferedReader(new FileReader(f));
			String help="";
			while((help=(bReader.readLine()))!=null) {
				numbers[counter]=Integer.valueOf(help);
				counter++;
			}
			bReader.close();
			
			Calculate_Size();
			for(Integer z: numbers) {
				Add_to_Tree(z);
			}
			Search_Children();
			Search_Parents();
			Tree_Sort();
			counter=0;
			for(Node n: lst_Nodes) {
				numbers[counter]=n.value;
				counter++;
			}
			
			for(Integer l: numbers) {
				System.out.println(l);
			}
			end=System.currentTimeMillis();
			time=end-start;
			System.out.println("Es hat "+time+" Millisekunden gedauert!");

		}

		private static void Tree_Sort() {
			// TODO Auto-generated method stub
			counter=lst_Nodes.size()-1;
			while(counter>=3) {
				is_sorted=false;
				while (is_sorted == false) {
					is_sorted = true;
					for (Node n : lst_Nodes) {
						if (1<n.number&&n.number<=counter) {
							parent = n.parent;
							parent--;
							if (n.value > lst_Nodes.get(parent).value) {
								is_sorted = false;
								k = lst_Nodes.get(parent).value;
								lst_Nodes.get(parent).value = n.value;
								n.value = k;
							}
						}
					}
				}
				k = lst_Nodes.get(0).value;
				lst_Nodes.get(0).value = lst_Nodes.get(counter).value;
				lst_Nodes.get(counter).value = k;
				counter--;
			}
			
		}

		private static void Search_Parents() {
			// TODO Auto-generated method stub
			for(Node n: lst_Nodes) {
				if(n.level>1) {
					if(n.number%2==1) {
						number=n.number-1;
					}
					else {
						number=n.number;
					}
					position=number-Calculate_Power(n.level-1);
					for(Node m: lst_Nodes) {
						if(m.level==n.level-1&&m.position==position) {
							n.parent=m.number;
							break;
						}
					}
				}
			}
		}

		private static void Search_Children() {
			// TODO Auto-generated method stub
			for(Node n: lst_Nodes) {
				if(n.level<levels) {
					n.children1 = n.position + Calculate_Power(n.level);
					if(n.children1>numbers.length) {
						n.children1=0;
					}
					n.children2 = n.position + Calculate_Power(n.level) + 1;
					if(n.children2>numbers.length) {
						n.children2=0;
					}
				}
			}
		}

		private static void Add_to_Tree(Integer z) {
			// TODO Auto-generated method stub
			akt_size=Calculate_Power(akt_level)-1;
			if(akt_size<=1) {
				Node akt_node = new Node();
				akt_node.number=akt_number;
				akt_node.position=akt_position;
				akt_node.level=akt_level;
				akt_node.value=z;
				lst_Nodes.add(akt_node);
				akt_level++;
				akt_number++;
				akt_position=0;
			}
			else {
				if(akt_number>=akt_size) {
					Node akt_node = new Node();
					akt_node.position=akt_position;
					akt_node.number=akt_number;
					akt_node.level=akt_level;
					akt_node.value=z;
					lst_Nodes.add(akt_node);
					akt_level++;
					akt_position=0;
					akt_number++;
					
				}
				else {
					Node akt_node = new Node();
					akt_node.position=akt_position;
					akt_node.number=akt_number;
					akt_node.level=akt_level;
					akt_node.value=z;
					lst_Nodes.add(akt_node);
					akt_position=akt_position+2;
					akt_number++;
				}
			}
		}

		private static void Calculate_Size() {
			// TODO Auto-generated method stub
			while(numbers.length>size) {
				size=size+Calculate_Power(levels);
				levels++;
			}
		}

		private static int Calculate_Power(int counter) {
			// TODO Auto-generated method stub
			
			if(counter>0) {
				return Calculate_Power(counter-1)*2;

			}
			else {
				return 1;
			}
		}

}
