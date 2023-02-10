package com.example.project;

public class Cube {


	static String[][] face = {
		{"1","2","3"},
		{"4","5","6"},
		{"7","8","9"}
		};

	static void move(String[][][] Cube, String input){
		switch(input){
			case "u":
				break;

			case "l":
				break;

			case "d":
				break;

			case "r":
				break;

			case "f":
				break;
			
			case "b":
				break;
		}
	}

	static void show(String[][] Face){
		for(String[] i: Face){
			for(String j: i){
				System.out.print(j);
			}
			System.out.println();
		}
	}

	static void rotateFace(String[][]Face, boolean clockwise){

		String[][] tempFace = new String[3][3];

		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				tempFace[i][j] = Face[i][j];

		if(clockwise){
			//order is Face[y][x] or Face[row][col]
			
			// Below comments were another solution provided by S.Luther
			// if(clockwise){
			// 	rotateFace(face, false);
			// 	rotateFace(face, false);
			// 	rotateFace(face, false);
			// }else{
			// 	for(int i=0; i<3;i++)
			// 		for(int j=0; j<3;j++)
			// 			Face[i][j] = tempFace[j][i];
			// 	String[] temp = new String[3];
			// 	for(int k=0; k<3; k++)
			// 		temp[k] = Face[0][k];
			// 	Face[0] = Face[2];
	
			// 	Face[2] = temp;
			
			Face[0][0] = tempFace[2][0];

			Face[0][1] = tempFace[1][0];
			Face[0][2] = tempFace[0][0];
			Face[1][0] = tempFace[2][1];
			Face[1][1] = tempFace[1][1];
			Face[1][2] = tempFace[0][1];
			Face[2][0] = tempFace[2][2];
			Face[2][1] = tempFace[1][2];
			Face[2][2] = tempFace[0][2];
		} else {
			Face[0][0] = tempFace[0][2];

			Face[0][1] = tempFace[1][2];
			Face[0][2] = tempFace[2][2];
			Face[1][0] = tempFace[0][1];
			Face[1][1] = tempFace[1][1];
			Face[1][2] = tempFace[2][1];
			Face[2][0] = tempFace[0][0];
			Face[2][1] = tempFace[1][0];
			Face[2][2] = tempFace[2][0];
		}
	}

	public static void main(final String[] args) {
		rotateFace(face, true);
		show(face);
		rotateFace(face, false);
		show(face);
	}
}

