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
				numbers[counter]=n.getValue();
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
						if (1<n.getNumber()&&n.getNumber()<=counter) {
							parent = n.getParent();
							parent--;
							if (n.getValue() > lst_Nodes.get(parent).getValue()) {
								is_sorted = false;
								k = lst_Nodes.get(parent).getValue();
								lst_Nodes.get(parent).setValue(n.getValue());
								n.setValue(k);
							}
						}
					}
				}
				k = lst_Nodes.get(0).getValue();
				lst_Nodes.get(0).setValue(lst_Nodes.get(counter).getValue());
				lst_Nodes.get(counter).setValue(k);
				counter--;
			}
			
		}

		private static void Search_Parents() {
			// TODO Auto-generated method stub
			for(Node n: lst_Nodes) {
				if(n.getLevel()>1) {
					if(n.getNumber()%2==1) {
						number=n.getNumber()-1;
					}
					else {
						number=n.getNumber();
					}
					position=number-Calculate_Power(n.getLevel()-1);
					for(Node m: lst_Nodes) {
						if(m.getLevel()==n.getLevel()-1&&m.getPosition()==position) {
							n.setParent(m.getNumber());
							break;
						}
					}
				}
			}
		}

		private static void Search_Children() {
			// TODO Auto-generated method stub
			for(Node n: lst_Nodes) {
				if(n.getLevel()<levels) {
					n.setChildren1(n.getPosition() + Calculate_Power(n.getLevel()));
					if(n.getChildren1()>numbers.length) {
						n.setChildren1(0);
					}
					n.setChildren2(n.getPosition()+ Calculate_Power(n.getLevel()) + 1);
					if(n.getChildren2()>numbers.length) {
						n.setChildren2(0);
					}
				}
			}
		}

		private static void Add_to_Tree(Integer z) {
			// TODO Auto-generated method stub
			akt_size=Calculate_Power(akt_level)-1;
			if(akt_size<=1) {
				Node akt_node = new Node();
				akt_node.setNumber(akt_number);;
				akt_node.setPosition(akt_position);
				akt_node.setLevel(akt_level);;
				akt_node.setValue(z);;
				lst_Nodes.add(akt_node);
				akt_level++;
				akt_number++;
				akt_position=0;
			}
			else {
				if(akt_number>=akt_size) {
					Node akt_node = new Node();
					akt_node.setPosition(akt_position);;
					akt_node.setNumber(akt_number);;
					akt_node.setLevel(akt_level);;
					akt_node.setValue(z);;
					lst_Nodes.add(akt_node);
					akt_level++;
					akt_position=0;
					akt_number++;
					
				}
				else {
					Node akt_node = new Node();
					akt_node.setPosition(akt_position);;
					akt_node.setNumber(akt_number);;
					akt_node.setLevel(akt_level);;
					akt_node.setValue(z);
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
