class FindRepeatNumber {
  
  public int findRepeatNumber(int[] nums) {
    int n = nums.length;
    boolean[] has = new boolean[n];
    int i = 0;
    int curr = 0;
    while (i < n) {
      curr = nums[i];
      if (has[curr]) {
        return curr;
      } else {
        has[curr] = true;
      }
      i += 1;
    }
    return curr;
  }

  public static void main(String[] args) {
    FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
    int[] testArray = {1, 2, 3, 4, 4};
    int result = findRepeatNumber.findRepeatNumber(testArray);
    System.out.println(result);
  }
}