package Sudoku;
import java.util.Scanner;
public class main
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc= new Scanner(System.in);
		int[] mat1[]=new int[9][9];
		System.out.println("\t\t=================================================");
		System.out.println("\t\t|                                               |");
		System.out.println("\t\t|        --------------------------------       |");
		System.out.println("\t\t|                     SUDOKU                    |");
		System.out.println("\t\t|        --------------------------------       |");
		System.out.println("\t\t|                                               |");
		System.out.println("\t\t=================================================\n");
		int N = 9, K = 50,i,j,k,l;
		int X;
		System.out.println("ENTER:\n\n1>>GET SOLUTION\n\n2>> PLAY SUDOKU\n\n-->");
		X=sc.nextInt();
		if(X==1)
		{
			S1 sudoku = new S1(N, K);
			solve sudoku1=new solve();
			System.out.println("\nENTER PUZZLE");
			for(i=0;i<9;i++)
			{
				for(j=0;j<9;j++)
				{
					int a=sc.nextInt();
					mat1[i][j]=a;
				}
			}
			System.out.println("\nSOLUTION");
			if (sudoku1.solveSudoku(mat1, N)) 
				sudoku1.print(mat1, N); // print solution
			System.out.println("\n\nHOPE YOU ARE SATISFIED WITH THE SOLUTION....HAVE A NICE DAY!!!\n");
		}
		else 
		{
			int choice;
			System.out.println("\n\n\n\nENTER DIFFICULTY LEVEL:");
			System.out.println("\n\n\n1>>VERY EASY\n\n2>>EASY\n\n3>>MEDIUM\n\n4>>HARD\n\n\n-->>");
			choice=sc.nextInt();
			switch(choice)
			{
			case '1': K=25;
			break;
			case '2': K=28;
			break;
			case '3': K=32;
			break;
			case '4': K=35;
			break;
			default :
			}
			S1 sudoku = new S1(N, K);
			System.out.println("SOLVE:\n");
			sudoku.fillValues(); 
			sudoku.printSudoku();
			int f1;
			System.out.println("ENTER:\n\n1>> GET SOLUTION\n\n2>> CHECK SOLUTION\n\n-->");
			f1=sc.nextInt();
			solve sudoku1=new solve();
			if(f1==1)
			{
				System.out.println("SOLUTION:\n");
				if (sudoku1.solveSudoku(sudoku.mat, N)) 
					sudoku1.print(sudoku.mat, N); // print solution
				System.out.println("\n\nTHANKS FOR PLAYING....HAVE A NICE DAY!!!\n");
			}
			else 
			{
				System.out.println("ENTER SOLUTION:\n");
				for(i=0;i<9;i++)
				{
					for(j=0;j<9;j++)
					{
						int a=sc.nextInt();
						mat1[i][j]=a;
					}
				}
				int f=0;
				if (sudoku1.solveSudoku(sudoku.mat, N)) 
				{ 
					for(i=0;i<9;i++)
					{
						for(j=0;j<9;j++)
						{
							if(mat1[i][j]!=sudoku.mat[i][j])
							{
								f=1;
								break;
							}
						}
						if(f==1)
							break;
					}
					if(f==1)
					{
						System.out.println("\nWRONG SOLUTION\n");
						System.out.println("\nRIGHT SOLUTION:\n");
						sudoku1.print(sudoku.mat, N); // print solution 
						System.out.println("\n\nTHANKS FOR PLAYING....HAVE A NICE DAY!!!\n");
					}
					else
					{
						System.out.println("\nRIGHT SOLUTION\n");
						System.out.println("\nANSWER:\n");
						sudoku1.print(sudoku.mat, N); // print solution
						System.out.println("\n\nTHANKS FOR PLAYING....HAVE A NICE DAY!!!\n");
					}
				}  
				else
				{ 
					System.out.println("NO SOLUTION"); 
				} 
			}
		}
	}
}
