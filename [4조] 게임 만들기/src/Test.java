import java.util.List;

import 객체모음.Student;
import 메소드모음.GameRepoRanking;
import 메소드모음.Inventory;
import 메소드모음.PickItem;

public class Test {
	public static void main(String[] args) {
		Inventory i = new Inventory(new Student("dd", "당리초", 500), "캐릭터");
		System.out.println(i.ItemAcquisition("캐릭터").toString());
	}
}
