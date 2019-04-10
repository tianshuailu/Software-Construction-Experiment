package P3;

import java.util.ArrayList;
import P3.Person;


public class FriendshipGraph {

	ArrayList<Person> person = new ArrayList<Person>();
	
	public void addVertex(Person A) {
		person.add(A);
	}

	int[][] g = new int [1000][1000];
	public void addEdge(Person A,Person B) {
		int a=0,b=0;
		for(int i=0;i<person.size();i++) {
			if(person.get(i) == A) {
				a = i;
			}
			if(person.get(i) == B) {
				b = i;
			}
		}
		g[a][b] = 1;
	}
	
	public int getDistance(Person A,Person B) {
		int a=0,b=0;
		int[][] d = new int[1000][1000];
		for(int i=0;i<person.size();i++) {
			if(person.get(i) == A) {
				a = i;
			}
			if(person.get(i) == B) {
				b = i;
			}
		}
		return floyd(a,b,person.size(), d,g);
	}
	
	int floyd(int a,int b,int n, int A[][], int C[][])
	{
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(C[i][j] != 1)
					C[i][j] = 1000;
				A[i][j] = C[i][j];
			}
		}
		if(A[a][b] == 1000&&a == b) {
			return 0;
		}
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if((A[i][k] + A[k][j] < A[i][j])) {
						A[i][j] = A[i][k] + A[k][j];
					}	
				}
			}
		}
		if(A[a][b]==1000&&a != b) {
			return -1;
		}
		return A[a][b];
	}
}

