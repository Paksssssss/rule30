package rule30;

import java.util.Scanner;



/**
 *
 * @author User
 */
public class Rule30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Parent Generation: ");
        String input = scanner.nextLine();
        while(!input.matches("[0-1]*")){
            System.out.println("Invalid Input: ");
            input = scanner.nextLine();
        }
        System.out.println("Input Number of Generations: ");
        String newGen = scanner.nextLine();
        while(!input.matches("[0-9]*")){
            System.out.println("Invalid Input: ");
            newGen = scanner.nextLine();
        }
        System.out.println("Parent Gen >>> " + input);
        System.out.println("Generation/s >>> " + newGen);
        
        char[][] grid = new char[Integer.parseInt(newGen)][input.length()];
        for(int i = 0; i < Integer.parseInt(newGen);i++){
            char left, middle, right;
            for (int j = 0; j < input.length(); j++) {
                if(i == 0){
                    if(j == 0){
                        left = '0';
                        middle = input.charAt(j);
                        right = input.charAt(j+1);
                    }
                    else if( j == input.length()-1){
                        left = input.charAt(j-1);
                        middle = input.charAt(j);
                        right = '0';
                    }
                    else{
                        left = input.charAt(j-1);
                        middle = input.charAt(j);
                        right = input.charAt(j+1);
                    }
                } else {
                    if(j == 0){
                        left = '0';
                        middle = grid[i-1][j];
                        right = grid[i-1][j+1];
                    }
                    else if( j == input.length()-1){
                        left = grid[i-1][j-1];
                        middle = grid[i-1][j];
                        right = '0';
                    }
                    else{
                        left = grid[i-1][j-1];
                        middle = grid[i-1][j];
                        right = grid[i-1][j+1];
                    }
                }
//                System.out.println(left + " " + middle + " " + right);
                if(left == '1' && middle == '1' && right == '1'){
                    grid[i][j] = '0';
                } else  if(left == '1' && middle == '1' && right == '0'){
                    grid[i][j] = '0';
                } else if(left == '1' && middle == '0' && right == '1'){
                    grid[i][j] = '0';
                } else if(left == '1' && middle == '0' && right == '0'){
                    grid[i][j] = '1';
                } else if(left == '0' && middle == '1' && right == '1'){
                    grid[i][j] = '1';
                } else if(left == '0' && middle == '1' && right == '0'){
                    grid[i][j] = '1';
                } else if(left == '0' && middle == '0' && right == '1'){
                    grid[i][j] = '1';
                } else if(left == '0' && middle == '0' && right == '0'){
                    grid[i][j] = '0';
                }
            }
        }
        printThis(input, grid, Integer.parseInt(newGen));
        
    }
    
    static void printThis(String parentGen, char[][] newGenerations, int numGen){
        System.out.println("Rule 30\n");
        
        System.out.print("| ");
        for(int i = 0; i <parentGen.length();i++){
            System.out.print(parentGen.charAt(i)+" ");
        }
        System.out.println("|");
        for (int i = 0; i < numGen; i++) {
            System.out.print("| ");
            for (int j = 0; j < parentGen.length(); j++) {
                System.out.print(newGenerations[i][j] + " ");
            }
            System.out.println("|");
        }
    }
    
}
