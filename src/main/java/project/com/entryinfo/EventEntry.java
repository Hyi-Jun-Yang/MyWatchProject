package project.com.entryinfo;

import java.util.ArrayList;
import java.util.Random;

public class EventEntry {

	ArrayList<Integer> p_list = new ArrayList<Integer>();
	int[] p_data = new int[]{
		1,
		2,2,2,2,2,
		3,3,3,3,3,
		3,3,3,3,3,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		4,4,4,4,4,
		0,0,0,0,0,
		0,0,0,0,0,
		0,0,0,0,0,
		0,0,0,0,0,
		0,0,0,0,0,
		0,0,0,0,0,0,0,0,0
	};
	Random r = new Random();
	public EventEntry() {
		for (int i = 0; i < p_data.length; i++) {
			p_list.add(p_data[i]);
			
		}
	
	}

	public int[] getEntryResult(){
		
		
		
		//1�� : 1/100
		//2�� : 5/100
		//3�� : 10/100
		//4�� : 50/100
		// �Ѵ�÷ 66��, ��34�� 
		final int e_id = 1;
		int is_win = 0;
		int win_rank = 0;
		int p_num = 0;
		

		int ranSu = r.nextInt(p_list.size());
		System.out.println();
		System.out.println("ranSu:"+ranSu);
		if(p_list.get(ranSu)!=0){
			is_win = 1;
			
			switch (p_list.get(ranSu)) {
			case 1:
				win_rank = 1;
				p_num = 1;
				break;
			case 2:
				win_rank = 2;
				p_num = 2;
				break;
			case 3:
				win_rank = 3;
				p_num = 3;
				break;
			case 4:
				win_rank = 4;
				p_num = 4;
				break;

			default:
				win_rank = 0;
				p_num = 0;
				break;
			}
			
		}else{
			System.out.println("��");
		}
		p_list.remove(ranSu);
		System.out.println("p_list.size():"+p_list.size());

		
		//e_id = 1,is_win=0, win_rank=2,  p_num = 3
		return new int[]{e_id,is_win,win_rank,p_num};
	}
	
	
	
}
