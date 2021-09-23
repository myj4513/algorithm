package level2.alphabetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for(int j=0;j<n;j++){
            String[] s = scanner.nextLine().split(" ");
            int size = Integer.parseInt(s[0]);
            Set<Character> set = new HashSet<>();

            for(int i=0;i<size+1;i++){
                String letter = s[i*2+1];
                for(int k=0;k<letter.length();k++){
                    set.add(letter.charAt(k));
                }
            }
            Character[] characters = set.toArray(new Character[9]);
            for(int aa = 0;aa<9;aa++){
                for(int bb = 0;bb!=aa && bb<9;bb++){
                    for(int cc = 0;cc!=aa && cc!=bb && cc<9;cc++){
                        for(int dd = 0;dd!=aa && dd!=bb && dd!=cc && dd<9;dd++){
                            for(int ee = 0;ee!=aa && ee!=bb && ee!=cc && ee!=dd && ee<9;ee++){
                                for(int ff = 0;ff!=aa && ff!=bb && ff!=cc && ff!=dd && ff!=ee && ff<9;ff++){
                                    for(int gg = 0;gg!=aa && gg!=bb && gg!=cc && gg!=dd && gg!=ee && gg!=ff && gg<9;gg++){
                                        for(int hh = 0;hh!=aa && hh!=bb && hh!=cc && hh!=dd && hh!=ee && hh!=ff && hh!=gg && hh<9;hh++){
                                            for(int ii = 0;ii!=aa && ii!=bb && ii!=cc && ii!=dd && ii!=ee && ii!=ff && ii!=gg && ii!=hh && ii<9;ii++){
                                                characters[aa] = 1;
                                                characters[bb] = 2;
                                                characters[cc] = 3;
                                                characters[dd] = 4;
                                                characters[ee] = 5;
                                                characters[ff] = 6;
                                                characters[gg] = 7;
                                                characters[hh] = 8;
                                                characters[ii] = 9;
                                                for(int k=0;k<size;k++){
                                                    for(int l=0;l<s[2*k+1].length();l++){
                                                        int sum = 0;
                                                        //sum +=

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
