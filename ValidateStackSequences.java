/**
 * 30
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */

class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || popped == null) {
            return false;
        }

        int pushedIndex = 0; 
        int poppedIndex = 0;
        int pushedLen = pushed.length;
        int poppedLen = popped.length;

        if (pushedLen != poppedLen) {
            return false;
        }
        
        boolean[] isPushed = new boolean[pushedLen];
        boolean[] isPopped = new boolean[pushedLen];

        while (poppedIndex < poppedLen && pushedIndex < pushedLen) {

            if (popped[poppedIndex] != pushed[pushedIndex]) {
                isPushed[pushedIndex] = true;
                pushedIndex += 1;
            } else {
                isPopped[pushedIndex] = true;
                poppedIndex += 1;
                // scan to beginning
                if (pushedIndex != 0) {
                    for (int i = pushedIndex - 1; i >= 0 && poppedIndex < poppedLen; i -= 1) {
                        if (pushed[i] == popped[poppedIndex]) {
                            isPopped[i] = true;
                            poppedIndex += 1;
                        }
                    }
                }
                pushedIndex += 1;
            }
        }

        if (pushedIndex == pushedLen && poppedIndex == poppedLen) {
            return true;
        } else {
            return false;
        }
    }
}