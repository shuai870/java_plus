public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue; // 当i等于2时，跳过此次循环迭代，进入下一次迭代
            }else {
                System.out.println("当前迭代值: " + i);
            }
        }

    }
}