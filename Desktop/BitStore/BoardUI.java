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
			case 1: // 게시글 조회,
				board.selectBoard();
				break;
			case 2: // 게시글 상세 조회,
				board.selectBoardByNo();
				break;
			case 3: // 게시글 등록, Board클래스의 insertBoard(Board)
				board.insertBoard();
				break;
			case 4: // 게시글 수정, Board클래스의 updateBoard(Board) : boolean 호출
				board.updateBoard();
				break;
			case 5: // 게시글 삭제, Board클래스의 deleteBoard(int) : boolean 호출
				board.deleteBoard();
				break;
			case 6: // 돌아가기
				if (currentLoginUser.getID().equals("admin")) { // 현재 로그인한 사용자가 관리자라면
					loginUI.admin(); // 관리자 페이지로 복귀
				} else {
					loginUI.user(); // 사용자 페이지로 복귀
				}
				break;
			case 0:
				quit();
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
	}

	private void quit() {
		System.out.println("안녕히 가세요^^!");
		System.exit(0);
	}

	private int boardMenu() {
		int inputNum = 0;
		System.out.println("-----------------");
		System.out.println("1. 게시글 조회");
		System.out.println("2. 게시글 상세 조회");
		System.out.println("3. 게시글 등록");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("6. 돌아가기");
		System.out.println("0. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		
		try {
			inputNum = Integer.parseInt(sc.nextLine());
			
		}catch (Exception e) {
			System.out.println("잘못입력하셨습니다. ");
			boardMenu();
			
		}
		return inputNum;
	}

}
