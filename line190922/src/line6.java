import java.util.Scanner;

public class line6 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sorting = sc.next();
        
        int maxheight = 0;
        int width = 0; 
        int[] w = new int[N];
        String[] num = new String[N];
        int numcnt=0;
        for (int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			num[i] = sc.next();
			if(w[i] > maxheight) maxheight = w[i];
			width += w[i]*(num[i].length());
			numcnt += num[i].length();
		}
        maxheight = maxheight*2 -1;
        char[][] printing = new char[maxheight][width+numcnt];
        
        int x=0;
        int y=0;
        for (int i = 0; i < N; i++) {
        	int height = w[i]*2-1;
			if(sorting.equals("TOP")) {
				y=0;
			}else if(sorting.equals("BOTTOM")) {
				y = maxheight - height;
			}else {
				y = (maxheight - height)/2;
			}
        	for (int j = 0; j < num[i].length(); j++) {
				char c = num[i].charAt(j);
				if(c == '0') {
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
						printing[y+height-1][k] = '#';
					}
					for (int k = y; k < y+height ; k++) {
						printing[k][x] = '#';
						printing[k][x+w[i]-1] ='#';
					}
				}else if(c =='1') {
					for (int k = y; k < y+height; k++) {
						printing[k][x+w[i]-1] = '#';
					}
				}else if(c =='2') {
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
						printing[(y+height-1)/2][k] = '#';
						printing[y+height-1][k] = '#';
					}
					for (int k = y; k < (y+height)/2; k++) {
						printing[k][x+w[i]-1] = '#';
					}
					for (int k = (y+height)/2; k <y+height ; k++) {
						printing[k][x] = '#';
					}
				}else if(c =='3') {
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
						printing[(y+height-1)/2][k] = '#';
						printing[y+height-1][k] = '#';
					}
					for (int k = y; k < y+height; k++) {
						printing[k][x+w[i]-1] = '#';
					}
				}else if(c =='4') {
					for (int k = y; k < y+height; k++) {
						printing[k][x+w[i]-1] = '#';
					}
					for (int k = y; k < (y+height)/2; k++) {
						printing[k][x] = '#';
					}
					for (int k = x; k < x+w[i]; k++) {
						printing[(y+height-1)/2][k] = '#';
					}
				}else if(c =='5') {
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
						printing[(y+height-1)/2][k] = '#';
						printing[y+height-1][k] = '#';
					}
					for (int k = y; k < (y+height)/2; k++) {
						printing[k][x] = '#';

					}
					for (int k = (y+height)/2; k <y+height ; k++) {
						printing[k][x+w[i]-1] = '#';
					}
				}else if(c =='6') {
					for (int k = x; k < x+w[i]; k++) {
						printing[(y+height-1)/2][k] = '#';
						printing[y+height-1][k] = '#';
					}
					for (int k = y; k < y+height ; k++) {
						printing[k][x] = '#';
					}
					for (int k = (y+height)/2; k <y+height ; k++) {
						printing[k][x+w[i]-1] = '#';
					}
				}else if(c =='7') {
					for (int k = y; k < y+height ; k++) {
						printing[k][x+w[i]-1] = '#';
					}
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
					}
				}else if(c =='8') {
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
						printing[(y+height-1)/2][k] = '#';
						printing[y+height-1][k] = '#';
					}
					for (int k = y; k < y+height ; k++) {
						printing[k][x] = '#';
						printing[k][x+w[i]-1] ='#';
					}
				}else if(c =='9') {
					for (int k = x; k < x+w[i]; k++) {
						printing[y][k] = '#';
						printing[(y+height-1)/2][k] = '#';
					}
					for (int k = y; k < y+height ; k++) {
						printing[k][x+w[i]-1] ='#';
					}
					for (int k = y; k < (y+height)/2; k++) {
						printing[k][x] = '#';
					}
				}
				x+=w[i];
				for (int k = 0; k < maxheight; k++) {
					printing[k][x] = ' ';
				}
				x++;
			}
		}
        
        for (int i = 0; i < printing.length; i++) {
			for (int j = 0; j < printing[i].length; j++) {
				if(printing[i][j] == '#' || printing[i][j] == ' ') System.out.print(printing[i][j]);
				else System.out.print(".");
			}System.out.println();
		}
        
	}
}
