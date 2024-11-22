public class BOJ456 {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            max = Math.max(max, arr[i]);
        }
        int[] prime = new int[max + 1]; // 각 숫자가 어떤 소수로 나누어지는지 나타낼 배열
        for (int i = 2; i <= max; i++) {
            // 갱신이 된 값이라면 건너뜀
            if (prime[i] != 0)
                continue;
            // 해당 소수(i)로 이루어진 합성수들을 해당 소수로 나눠지는 것을 표시
            for (int j = i; j <= max; j += i) {
                if (prime[j] == 0)
                    prime[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            // 소인수 분해
            while (num > 1) {
                sb.append(prime[num]).append(" ");
                num /= prime[num];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 빠른 입력 함수
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}