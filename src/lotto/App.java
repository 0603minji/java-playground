package lotto;

import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                [ 로또 복권 프로그램 ]
                                
                1. 수동 발권
                2. 자동 발권
                3. 발권번호 조회
                4. 종료
                =============================
                메뉴 입력 > """);

        Scanner sc = new Scanner(System.in);
        int menu;

        menu = Integer.parseInt(sc.nextLine());

        switch (menu) {
            case 1: {
                while (true) {
                    clearConsole();
                    System.out.println("""
                            [ 수동 발권 ]
                            1~45 숫자 범위에서 원하는 번호를
                            스페이스 구분자로 6개 입력하세요.
                            숫자는 정렬되어 있지 않아도 상관없다.
                            ==================================
                            번호 > """);
                    String inputNum = sc.nextLine();
                    String[] inputNums = inputNum.split(" ");

                    for (int i = 0; i < 6; i++) {
                        if (i == 5) System.out.printf("%s", inputNums[i]);
                        else System.out.printf("%s ", inputNums[i]);
                    }

                    System.out.print("\n위의 번호가 맞나요? (Y/N)");
                    String yesNo = sc.nextLine();
                    if (yesNo.equals("Y")) break;
                }
            }
            break;
            case 2: {
                clearConsole();
                System.out.println("""
                        [ 자동 발권 ]
                                                    
                        ==================================
                        자동 발권 번호 > """);

                Random random = new Random();
                List<Integer> randomNums = new ArrayList<>(); // []
                int[] arr = new int[6];
                int i, j;

                for (i = 0; i < 6; i++) {
                    while (true) {
                        int randomNum = random.nextInt(45) + 1;
                        for (j = 0; j < 6; j++) {
                            if (arr[j] == randomNum) break;
                        }
                        if (j == 6) {
                            arr[i] = randomNum;
                            break;
                        }
                    }
                }

                for (i = 0; i < 6; i++) {
                        for (j = 0; j < 5 - i; j++) {
                            if (arr[j] > arr[j + 1]) {
                                int tmp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = tmp;
                            }
                        }
                }

                for (int i1 : arr) {
                    System.out.print(i1 + " ");
                }
            }
            case 3: {
            }
            case 4: {
            }
        }
    }

    public static void clearConsole() {
        // ANSI Escape 코드를 이용해 콘솔을 클리어합니다.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
