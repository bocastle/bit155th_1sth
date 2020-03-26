package BitStore.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import BitStore.domain.BoardVO;

public class Board {

	/*
	 * public Board() { BoardVO b1 = new BoardVO(); b1.setBoardTitle("gd");
	 * b1.setBoardContent("ss"); b1.setBoardWriter("ss"); b1.setBoardDate("ss");
	 * BitStore.boardList.put(3, b1);
	 * 
	 * 
	 * BoardVO b2 = new BoardVO(); b2.setBoardTitle("gd"); b2.setBoardContent("ss");
	 * b2.setBoardWriter("ss"); b2.setBoardDate("ss"); BitStore.boardList.put(4,
	 * b2);
	 * 
	 * 
	 * }
	 */
	// private ArrayList<BoardVO> list;
	static Scanner in = new Scanner(System.in);
	private int count = 1;

	Date d = new Date();
	SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");

	// 게시글 번호, 제목, 글쓴이, 날짜, 내용

	public void insertBoard() {

		BoardVO boardvo = new BoardVO();

		// add
		int a = 1;
		System.out.println("제목: ");
		boardvo.setBoardTitle(in.nextLine());
		// String title = in.nextLine();
		System.out.println("내용: ");
		boardvo.setBoardContent(in.nextLine());
		// String content = in.nextLine();
		System.out.println("글쓴이: ");
		boardvo.setBoardWriter(in.nextLine());
		// String writer = in.nextLine();
		System.out.println("오늘 날짜가 입력됩니다");
		boardvo.setBoardDate(form.format(d));
		// String date = ("오늘 날짜:" +form.format(d));
		boardvo.setBoardNo(++count);
		BitStore.boardList.put(count, boardvo);

		writeBoardList();

	}

	public void writeBoardList() {
		// 저장을 마지막
		File file = new File("Board.txt");  
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;

		try {
			 fos = new FileOutputStream(file);
			 bos = new BufferedOutputStream(fos);  
			 oos = new ObjectOutputStream(fos);

			oos.writeObject(BitStore.boardList);
		} catch (Exception e) {
			System.out.println("에러발생!!!");
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				bos.close();
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void updateBoard() {
		// 수정
		Set<Integer> set = BitStore.boardList.keySet();
		System.out.println("수정할 글 번호를 입력하세요");
		int inputNum = Integer.parseInt(in.nextLine());

		boolean flag = false;
		for (int i = 0; i < BitStore.boardList.size(); i++) {
			if (inputNum == BitStore.boardList.get(i).getBoardNo()) {
				flag = true;
				System.out.println("수정할 제목을 입력하세요 : ");
				BitStore.boardList.get(i).setBoardTitle(in.nextLine());
				System.out.println("수정할 내용을 입력하세요 : ");
				BitStore.boardList.get(i).setBoardContent(in.nextLine());
				return;
			}
		}
		if (flag == false) {
			System.out.println("입력한 글번호는 존재하지 않습니다.");
		}
		System.out.println("수정이 완료 되었습니다.");
	}

	public void deleteBoard() {
		// 삭제
		Set<Integer> set = BitStore.boardList.keySet();
		System.out.println("삭제할 글 번호를 입력하세요 : ");
		int inputNum = Integer.parseInt(in.nextLine());
		boolean flag = false;

		for (int i = 0; i < BitStore.boardList.size(); i++) {
			if (inputNum == BitStore.boardList.get(i).getBoardNo()) {
				flag = true;
				BitStore.boardList.remove(i);
				break;
			}
		}
		if (flag == false) {
			System.out.println("입력하신 번호는 존재하지 않습니다.");
			return;
		}
		System.out.println("게시글이 삭제 되었습니다.");
	}

	public void selectBoard() {
		// Iterator<String> mapIter = BitStore.boardList.keySet().iterator();
		// while (mapIter.hasNext()) {
		// String key = mapIter.next();
		// BoardVO value = BitStore.boardList.get(key);
		Set<Integer> set = BitStore.boardList.keySet();
		System.out.println("번호\t글쓴이\t제목\t내용\t날짜");
		for (Integer number : set) {
			int no = BitStore.boardList.get(number).getBoardNo();
			String writer = BitStore.boardList.get(number).getBoardWriter();
			String title = BitStore.boardList.get(number).getBoardTitle();
			String content = BitStore.boardList.get(number).getBoardContent();
			String date = BitStore.boardList.get(number).getBoardDate();
			System.out.println(no + "\t" + writer + "\t" + title + "\t" + content + "\t" + date);

			// System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", a, writer, title, date);
		}

	}

	public Board selectBoardByNo(int boardNo) {

		Set<Integer> set = BitStore.boardList.keySet();
		System.out.println("번호\t글쓴이\t제목\t내용\t날짜");
		for (Integer number : set) {
			int no = BitStore.boardList.get(number).getBoardNo();
			String writer = BitStore.boardList.get(number).getBoardWriter();
			String title = BitStore.boardList.get(number).getBoardTitle();
			String content = BitStore.boardList.get(number).getBoardContent();
			String date = BitStore.boardList.get(number).getBoardDate();
			System.out.println(no + "\t" + writer + "\t" + title + "\t" + content + "\t" + date);

		}
		return null;
	}

	// Iterator<String> mapIter = BitStore.boardList.keySet().iterator();
	// while (mapIter.hasNext()) {
	// String key = mapIter.next();
	// BoardVO value = BitStore.boardList.get(key);
}
