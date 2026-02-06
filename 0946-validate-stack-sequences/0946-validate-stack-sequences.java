   class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // create a stack to simulate the push and pop operations
        Stack<Integer> stack = new Stack<>();
        int i = 0; // initialize an index to keep track of the next element in popped array
        for (int num : pushed) { // loop over the pushed array
            stack.push(num); // push the current element onto the stack
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                // if the top element of the stack is the same as the next element in popped
                // pop the top element from the stack and increment i to move to the next element in popped
                stack.pop();
                i++;
            }
        }
        // if the stack is empty, all elements have been popped in the correct order
        // return true, otherwise return false
        return stack.isEmpty();
    }
}