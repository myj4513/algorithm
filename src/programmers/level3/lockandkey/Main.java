package programmers.level3.lockandkey;

/**
 * 프로그래머스 레벨 3 자물쇠와 열쇠
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
}

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length + key.length - 1; i++) {
            for (int j = 0; j < lock.length + key.length - 1; j++) {
                for (int r = 0; r < 4; r++) {
                    int[][] paddedLock = padding(lock, key.length - 1);
                    match(key, paddedLock, i, j, r, lock.length);
                    if (check(paddedLock, lock.length, key.length)) {
                        return true;
                    }
                }
            }
        }


        return false;
    }

    private boolean check(int[][] paddedLock, int lockSize, int keySize) {
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (paddedLock[keySize - 1 + i][keySize - 1 + j] != 1)
                    return false;
            }
        }
        return true;
    }

    private void match(int[][] key, int[][] paddedLock, int beginR, int beginC, int r, int lockSize) {
        int length = key.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (r == 0) {
                    paddedLock[beginR + i][beginC + j] += key[i][j];
                } else if (r == 1) {
                    paddedLock[beginR + i][beginC + j] += key[length-1 - j][i];
                } else if (r == 2) {
                    paddedLock[beginR + i][beginC + j] += key[length-1 - i][length-1 - j];
                } else if (r == 3) {
                    paddedLock[beginR + i][beginC + j] += key[j][length-1-i];
                }
            }
        }
    }

    private int[][] padding(int[][] lock, int padSize) {
        int[][] result = new int[lock.length + padSize * 2][lock.length + padSize * 2];
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                result[padSize + i][padSize + j] = lock[i][j];
            }
        }
        return result;
    }
}

/*
for (int k = 0; k < paddedLock.length; k++) {
        System.out.println(Arrays.toString(paddedLock[k]));
        }
        System.out.println("===========================");*/
