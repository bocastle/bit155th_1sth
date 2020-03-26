import java.util.Random;
import java.util.Scanner;

public class Lotto {
	private int[] numbers;
	private Scanner scanner; //= new Scanner(System.in);
	private Random r; //= new Random();
	
	public Lotto() {
		//�ʱ�ȭ (member field)
		numbers = new int[6]; //�迭�� ���� 6�� �����  
		scanner = new Scanner(System.in); //���� �޴´�.
		r = new Random(); 
	}
	
	public void selectLottoNumber() {
	loop_1: while(true) {
			 String selectionnum = showMenu(scanner);
			 switch (selectionnum) {
			 	case "1":
			 			//makeLottoNumber(r,numbers); //�ǹ�ȣ ����
			 			//showLottoNumbers(); //���� �ϰ� ����ϱ�
			 			do {
			 				makeLottoNumber(r,numbers); //�ǹ�ȣ ����
			 			}while(!checkAverage());
			 			showLottoNumbers(); //���� �ϰ� ����ϱ�
					break;
			 	case "2": //���α׷� ���� : return (�Լ� Ż��) , System.exit(0) , �󺧰� 
					System.out.println("Good Lucky^^");
			 		break loop_1;
				default: 
					System.out.println("Not in Operation~~");
					break;
			}
		}
	}
	
	//private .. ���ο����� ���
	private String showMenu(Scanner sc) { //�����̴ϱ� (parameter)
		System.out.println("*******************");
		System.out.println("*1. ��÷ ���� ��ȣ ����*");
		System.out.println("*2. ���α׷� ���� ^^!*");
		System.out.println("*******************");
		System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ���:");
		String selectionnum = sc.nextLine();
		return selectionnum;
	}
	
	//��ȣ ���� , �ߺ��� ����
	private void makeLottoNumber(Random r , int[] numbers) { //parameter ����
		for(int i = 0 ; i < 6 ; i++) {
			numbers[i] = r.nextInt(45)+1;
			 for(int j = 0 ; j < i ; j++) { //j < i (ä���� ���� ��ŭ ��)
				 if(numbers[i] == numbers[j]) {
					 i--; //point ���� ���� ���� �ٲپ �Ѵ�
					 break;
				 }
			 }
		}
	}
	//ȭ�� ��±��
	private void showLottoNumbers() {
		System.out.println("[������ Lotto ��ȣ]");
		
		for(int i = 0 ; i < numbers.length ;i++) {
			for(int j=i+1 ; j < numbers.length ; j++) {
				if(numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	
		//����ϱ�
		for(int i = 0 ; i < numbers.length ; i++) {
			System.out.printf("[%2d]",numbers[i]);
		}
		System.out.println();
	}
	
	//��Ģ (�迭�� ���� ����� Ư�� ������ ����� ������)
	private boolean checkAverage() {
		int sum = 0;
		int average = 0;
		for(int num : numbers) {
			sum+=num;
		}
		average = sum/numbers.length;
		System.out.println("��� : " + average);
		return (average >= 15 && average <= 35); //true , false
	}
}

