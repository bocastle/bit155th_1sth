package Store.ui;

import java.util.Scanner;

import Store.domain.UserVO;
import Store.util.BitStore;
import Store.util.Board;

public class BoardUI {
	private Scanner sc;
	private LoginUI loginUI;
	private UserVO currentLoginUser;
	private Board board;

	public BoardUI() {
		sc = new Scanner(System.in);
		loginUI = new LoginUI();
		board = new Board();
		currentLoginUser = BitStore.currentLoginUser;
	}

	public void commonBoard() {
		while (true) {
			switch (boardMenu()) {
			case 1: // �Խñ� ��ȸ,
				board.selectBoard();
				break;
			case 2: // �Խñ� �� ��ȸ,
				board.selectBoardByNo();
				break;
			case 3: // �Խñ� ���, BoardŬ������ insertBoard(Board)
				board.insertBoard();
				break;
			case 4: // �Խñ� ����, BoardŬ������ updateBoard(Board) : boolean ȣ��
				board.updateBoard();
				break;
			case 5: // �Խñ� ����, BoardŬ������ deleteBoard(int) : boolean ȣ��
				board.deleteBoard();
				break;
			case 6: // ���ư���
				if (currentLoginUser.getID().equals("admin")) { // ���� �α����� ����ڰ� �����ڶ��
					loginUI.admin(); // ������ �������� ����
				} else {
					loginUI.user(); // ����� �������� ����
				}
				break;
			case 0:
				quit();
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	private void quit() {
		System.out.println("�ȳ��� ������^^!");
		System.exit(0);
	}

	private int boardMenu() {
		int inputNum = 0;
		System.out.println("-----------------");
		System.out.println("1. �Խñ� ��ȸ");
		System.out.println("2. �Խñ� �� ��ȸ");
		System.out.println("3. �Խñ� ���");
		System.out.println("4. �Խñ� ����");
		System.out.println("5. �Խñ� ����");
		System.out.println("6. ���ư���");
		System.out.println("0. ����");
		System.out.println("-----------------");
		System.out.print("�޴� �� ó���� �׸��� �����ϼ��� : ");
		
		try {
			inputNum = Integer.parseInt(sc.nextLine());
			
		}catch (Exception e) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. ");
			boardMenu();
			
		}
		return inputNum;
	}

}
