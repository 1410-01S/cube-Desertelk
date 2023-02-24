package com.example.project;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cube {

	static String[][] cube = { {
			"r", "r", "r",
			"r", "r", "r",
			"r", "r", "r",
	}, {
			"b", "b", "b",
			"b", "b", "b",
			"b", "b", "b",
	}, {
			"o", "o", "o",
			"o", "o", "o",
			"o", "o", "o",
	}, {
			"g", "g", "g",
			"g", "g", "g",
			"g", "g", "g",
	}, {
			"y", "y", "y",
			"y", "y", "y",
			"y", "y", "y",
	}, {
			"w", "w", "w",
			"w", "w", "w",
			"w", "w", "w",
	}
	};


	class edgedFace {
		public int current_face;
		int[] edge1 = new int[4];// index 0 is the face and 1-3 are elements of face [1,0,1,2]
		int[] edge2 = new int[4];// [0,0,1,2]
		int[] edge3 = new int[4];// index 0 is the face and 1-3 are elements of face [1,0,1,2]
		int[] edge4 = new int[4];

		public edgedFace(int face) {
			current_face = face;

			switch (face) {
				case 0: // red face.
					edge1[0] = 1; // blue
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4; // yellow
					edge2[1] = 2;
					edge2[2] = 5;
					edge2[3] = 8;

					edge3[0] = 3; // green
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5; // white.
					edge4[1] = 2;
					edge4[2] = 5;
					edge4[3] = 8;
					break;

				case 1: // blue face

					edge1[0] = 2; // orange
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4; // yellow
					edge2[1] = 6;
					edge2[2] = 7;
					edge2[3] = 8;

					edge3[0] = 0; // red
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5; // white.
					edge4[1] = 0;
					edge4[2] = 1;
					edge4[3] = 2;
					break;

				case 2: // orange face

					edge1[0] = 3; // green
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4; // yellow
					edge2[1] = 0;
					edge2[2] = 3;
					edge2[3] = 6;

					edge3[0] = 1; // blue
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5; // white.
					edge4[1] = 0;
					edge4[2] = 3;
					edge4[3] = 6;
					break;

				case 3: // green face

					edge1[0] = 0; // red
					edge1[1] = 2;
					edge1[2] = 5;
					edge1[3] = 8;

					edge2[0] = 4; // yellow
					edge2[1] = 0;
					edge2[2] = 1;
					edge2[3] = 2;

					edge3[0] = 2; // orange
					edge3[1] = 0;
					edge3[2] = 3;
					edge3[3] = 6;

					edge4[0] = 5; // white.
					edge4[1] = 6;
					edge4[2] = 7;
					edge4[3] = 8;
					break;

				case 4: // yellow face

					edge1[0] = 2; // orange
					edge1[1] = 0;
					edge1[2] = 1;
					edge1[3] = 2;

					edge2[0] = 3; // green
					edge2[1] = 6;
					edge2[2] = 7;
					edge2[3] = 8;

					edge3[0] = 0; // red
					edge3[1] = 0;
					edge3[2] = 1;
					edge3[3] = 2;

					edge4[0] = 1; // blue.
					edge4[1] = 0;
					edge4[2] = 1;
					edge4[3] = 2;
					break;
				case 5: // white face
					edge1[0] = 2; // orange
					edge1[1] = 6;
					edge1[2] = 7;
					edge1[3] = 8;

					edge2[0] = 1; // blue
					edge2[1] = 6;
					edge2[2] = 7;
					edge2[3] = 8;

					edge3[0] = 0; // red
					edge3[1] = 6;
					edge3[2] = 7;
					edge3[3] = 8;

					edge4[0] = 3; // green.
					edge4[1] = 6;
					edge4[2] = 7;
					edge4[3] = 8;
					break;
			}
		}
	}

	public void turnFace(int index, String direction) {
		edgedFace eFace = new edgedFace(index);

		String[][] copy = new String[6][9];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				copy[i][j] = cube[i][j];
			}
		}

		switch (direction) {
			case "c":
				cube[eFace.current_face][0] = copy[eFace.current_face][2];
				cube[eFace.current_face][1] = copy[eFace.current_face][5];
				cube[eFace.current_face][2] = copy[eFace.current_face][8];
				cube[eFace.current_face][3] = copy[eFace.current_face][1];
				cube[eFace.current_face][5] = copy[eFace.current_face][7];
				cube[eFace.current_face][6] = copy[eFace.current_face][0];
				cube[eFace.current_face][7] = copy[eFace.current_face][3];
				cube[eFace.current_face][8] = copy[eFace.current_face][6];

				// edge 1 changed
				cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
				cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
				cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

				// edge 2 changed
				cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
				cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
				cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

				// edge 3 changed
				cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
				cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
				cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

				// edge 4 changed
				cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
				cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
				cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

				break;
			case "cc":
				cube[eFace.current_face][0] = copy[eFace.current_face][6];
				cube[eFace.current_face][1] = copy[eFace.current_face][3];
				cube[eFace.current_face][2] = copy[eFace.current_face][0];
				cube[eFace.current_face][3] = copy[eFace.current_face][7];
				cube[eFace.current_face][5] = copy[eFace.current_face][1];
				cube[eFace.current_face][6] = copy[eFace.current_face][8];
				cube[eFace.current_face][7] = copy[eFace.current_face][5];
				cube[eFace.current_face][8] = copy[eFace.current_face][2];

				// edge 1 changed
				cube[eFace.edge1[0]][eFace.edge1[1]] = copy[eFace.edge2[0]][eFace.edge2[1]];
				cube[eFace.edge1[0]][eFace.edge1[2]] = copy[eFace.edge2[0]][eFace.edge2[2]];
				cube[eFace.edge1[0]][eFace.edge1[3]] = copy[eFace.edge2[0]][eFace.edge2[3]];

				// edge 2 changed
				cube[eFace.edge2[0]][eFace.edge2[1]] = copy[eFace.edge3[0]][eFace.edge3[1]];
				cube[eFace.edge2[0]][eFace.edge2[2]] = copy[eFace.edge3[0]][eFace.edge3[2]];
				cube[eFace.edge2[0]][eFace.edge2[3]] = copy[eFace.edge3[0]][eFace.edge3[3]];

				// edge 3 changed
				cube[eFace.edge3[0]][eFace.edge3[1]] = copy[eFace.edge4[0]][eFace.edge4[1]];
				cube[eFace.edge3[0]][eFace.edge3[2]] = copy[eFace.edge4[0]][eFace.edge4[2]];
				cube[eFace.edge3[0]][eFace.edge3[3]] = copy[eFace.edge4[0]][eFace.edge4[3]];

				// edge 4 changed
				cube[eFace.edge4[0]][eFace.edge4[1]] = copy[eFace.edge1[0]][eFace.edge1[1]];
				cube[eFace.edge4[0]][eFace.edge4[2]] = copy[eFace.edge1[0]][eFace.edge1[2]];
				cube[eFace.edge4[0]][eFace.edge4[3]] = copy[eFace.edge1[0]][eFace.edge1[3]];

				break;
		}
	}

	public void showCube() {
		int index = 0;
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < 3; y++) {
				for (int z = 0; z < 3; z++) {
					System.out.print(cube[x][index++]);
				}
				System.out.println();
			}
			index = 0;
			System.out.println();
		}
	}

	public static void main(final String[] args)
			throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Cube myCube = new Cube();
		ArrayList<String> commands = new ArrayList<>();
		ArrayList<String> requiredMoves = new ArrayList<>();

		boolean argsCheck = false;
		int argsRunIndex = 0;

		if (args.length > 0) {
			argsCheck = true;
		}

		boolean proceed = true;

		while (proceed) {
			String input;

			if (!argsCheck) {
				input = reader.readLine();
			} else {
				if (argsRunIndex == args.length) {
					argsCheck = false;
					input = "s";
				} else {
					input = args[argsRunIndex];
					argsRunIndex++;
				}
			}

			switch (input) {
				case "u":// yellow face
					myCube.turnFace(4, "c");
					myCube.showCube();
					commands.add("u");
					requiredMoves.add("u'");
					break;

				case "l":// orange face
					myCube.turnFace(2, "c");
					myCube.showCube();
					commands.add("l");
					requiredMoves.add("l'");
					break;

				case "d":// white face
					myCube.turnFace(5, "c");
					myCube.showCube();
					commands.add("d");
					requiredMoves.add("d'");
					break;

				case "r":// red face
					myCube.turnFace(0, "c");
					myCube.showCube();
					commands.add("r");
					requiredMoves.add("r'");
					break;

				case "f":// blue face
					myCube.turnFace(1, "c");
					myCube.showCube();
					commands.add("f");
					requiredMoves.add("f'");
					break;

				case "b":// green face
					myCube.turnFace(3, "c");
					myCube.showCube();
					commands.add("b");
					requiredMoves.add("b'");
					break;

				case "u'":
					myCube.turnFace(4, "cc");
					myCube.showCube();
					commands.add("u'");
					requiredMoves.add("u");
					break;

				case "l'":
					myCube.turnFace(2, "cc");
					myCube.showCube();
					commands.add("l'");
					requiredMoves.add("l");
					break;

				case "d'":
					myCube.turnFace(5, "cc");
					myCube.showCube();
					commands.add("d'");
					requiredMoves.add("d");
					break;

				case "r'":
					myCube.turnFace(0, "cc");
					myCube.showCube();
					commands.add("r'");
					requiredMoves.add("r");
					break;

				case "f'":
					myCube.turnFace(1, "cc");
					myCube.showCube();
					commands.add("f'");
					requiredMoves.add("f");
					break;

				case "b'":
					myCube.turnFace(3, "cc");
					myCube.showCube();
					commands.add("b'");
					requiredMoves.add("b");
					break;

				case "s": // This is meant to solve the cube.
					System.out.println(commands);
					Collections.reverse(requiredMoves);
					System.out.println(requiredMoves);
					break;

				case "q":
					proceed = false;
					break;
			}
		}
	}
}
