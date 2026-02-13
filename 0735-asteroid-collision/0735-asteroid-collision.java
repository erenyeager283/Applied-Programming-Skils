class Solution {
    public int[] asteroidCollision(int[] ast) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = ast.length;

        for(int i = 0; i <n; i++){
           boolean alive = true;
            while(!st.isEmpty() && st.peek() > 0 && ast[i] < 0){
                int sum = st.peek() + ast[i];
                if(sum > 0){
                    alive = false;
                    break;
                }else if(sum < 0) st.pop();
                else{
                    alive = false;
                    st.pop();
                    break;
                }    
            }
            if(alive) st.push(ast[i]);          
        }

        n = st.size();
        int [] arr = new int[n];
        for(int i = n - 1; i > -1; i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}