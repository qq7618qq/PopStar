package cn.campsg.practical.bubble.service;

import java.security.acl.Group;
import java.util.Iterator;
import java.util.Map;

import jdk.nashorn.internal.ir.WhileNode;

import org.apache.log4j.Logger;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.util.StarsUtil;

/**
 * 
 * ������ҵ���������࣬����Ϊ�����ṩ���·���<br>
 * 1. ������Ļ�������������<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	private Logger logger = Logger.getLogger(StarServiceImpl.class);

	/**
	 * ������Ļ������������ǣ�10 * 10��
	 * 
	 * @return �������б�-��������ʾ
	 */
	@Override
	public StarList createBubbleMatrix() {

		StarList stars = new StarList();

		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {

			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {

				Star star = new Star();
				// �����������ڻ����ϵ�λ��
				star.setPosition(new Position(row, col));
				// ���������������
				int typeIndex = (int) (Math.random() * StarService.STAR_TYPES);
				star.setType(StarType.valueOf(typeIndex));
				// �����б�
				stars.add(star);
			}
		}

		test(stars);

		return stars;

	}

	private void test(StarList stars) {

		stars.get(1).setType(Star.StarType.BLUE);

		stars.get(5).setType(Star.StarType.YELLOW);
		stars.get(15).setType(Star.StarType.YELLOW);
		stars.get(25).setType(Star.StarType.YELLOW);
		stars.get(35).setType(Star.StarType.YELLOW);
		stars.get(45).setType(Star.StarType.YELLOW);
		stars.get(55).setType(Star.StarType.YELLOW);
		stars.get(65).setType(Star.StarType.YELLOW);
		stars.get(75).setType(Star.StarType.YELLOW);
		stars.get(85).setType(Star.StarType.YELLOW);
		stars.get(95).setType(Star.StarType.YELLOW);

		stars.get(7).setType(Star.StarType.YELLOW);
		stars.get(17).setType(Star.StarType.YELLOW);
		stars.get(27).setType(Star.StarType.YELLOW);
		stars.get(37).setType(Star.StarType.YELLOW);
		stars.get(47).setType(Star.StarType.YELLOW);
		stars.get(57).setType(Star.StarType.YELLOW);
		stars.get(67).setType(Star.StarType.YELLOW);
		stars.get(77).setType(Star.StarType.YELLOW);
		stars.get(87).setType(Star.StarType.YELLOW);
		stars.get(97).setType(Star.StarType.YELLOW);

		stars.get(9).setType(Star.StarType.YELLOW);
		stars.get(19).setType(Star.StarType.YELLOW);
		stars.get(29).setType(Star.StarType.YELLOW);
		stars.get(39).setType(Star.StarType.YELLOW);
		stars.get(49).setType(Star.StarType.YELLOW);
		stars.get(59).setType(Star.StarType.YELLOW);
		stars.get(69).setType(Star.StarType.YELLOW);
		stars.get(79).setType(Star.StarType.YELLOW);
		stars.get(89).setType(Star.StarType.YELLOW);
		stars.get(99).setType(Star.StarType.YELLOW);

		stars.get(2).setType(Star.StarType.YELLOW);
		stars.get(12).setType(Star.StarType.YELLOW);
		stars.get(22).setType(Star.StarType.YELLOW);
		stars.get(32).setType(Star.StarType.YELLOW);
		stars.get(42).setType(Star.StarType.YELLOW);
		stars.get(52).setType(Star.StarType.YELLOW);
		stars.get(62).setType(Star.StarType.YELLOW);
		stars.get(72).setType(Star.StarType.YELLOW);
		stars.get(82).setType(Star.StarType.YELLOW);
		stars.get(92).setType(Star.StarType.RED);

		stars.get(93).setType(Star.StarType.YELLOW);
		stars.get(94).setType(Star.StarType.YELLOW);

		stars.get(96).setType(Star.StarType.YELLOW);
		stars.get(98).setType(Star.StarType.YELLOW);

		stars.get(0).setType(Star.StarType.PURPLE);
		stars.get(10).setType(Star.StarType.PURPLE);
		stars.get(20).setType(Star.StarType.PURPLE);
		stars.get(30).setType(Star.StarType.PURPLE);
		stars.get(40).setType(Star.StarType.PURPLE);
		stars.get(50).setType(Star.StarType.PURPLE);
		stars.get(60).setType(Star.StarType.PURPLE);
		stars.get(70).setType(Star.StarType.RED);
		stars.get(80).setType(Star.StarType.GREEN);
		stars.get(90).setType(Star.StarType.GREEN);

		stars.get(81).setType(Star.StarType.GREEN);
		stars.get(11).setType(Star.StarType.RED);

		stars.get(11).setType(Star.StarType.GREEN);
		stars.get(21).setType(Star.StarType.GREEN);
		stars.get(31).setType(Star.StarType.GREEN);
		stars.get(41).setType(Star.StarType.GREEN);
		stars.get(51).setType(Star.StarType.GREEN);
		stars.get(61).setType(Star.StarType.GREEN);
		stars.get(71).setType(Star.StarType.GREEN);
		stars.get(81).setType(Star.StarType.GREEN);
		stars.get(91).setType(Star.StarType.GREEN);

		stars.get(3).setType(Star.StarType.YELLOW);
		stars.get(13).setType(Star.StarType.YELLOW);
		stars.get(23).setType(Star.StarType.YELLOW);
		stars.get(33).setType(Star.StarType.YELLOW);
		stars.get(43).setType(Star.StarType.YELLOW);
		stars.get(53).setType(Star.StarType.YELLOW);
		stars.get(63).setType(Star.StarType.YELLOW);
		stars.get(73).setType(Star.StarType.YELLOW);
		stars.get(83).setType(Star.StarType.YELLOW);

	}

	/**
	 * �Ը��������ǣ��û�����ģ�Ϊ�����������ҡ�����·������Ѱ����ͬ���͵�������
	 * 
	 * @param base
	 *            ���������ǣ��û�����ģ�
	 * @param sList
	 *            ԭʼ�������б������������е������ǣ�
	 * @param clearStars
	 *            ��������������б�
	 */
	private void findStarsByPath(Star base, StarList sList, StarList clearStars) {
		// ��ȡ��ǰ����������ǵ��к���
		int row = base.getPosition().getRow();
		int col = base.getPosition().getColumn();
		StarType type = base.getType();

		Star star = null;

		// �����·�������ж�
		if (col - 1 >= 0) {
			// ���������߽������£���ȡ����������ǵ����������
			star = (Star) sList.lookup(row, (col - 1));
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б���
					clearStars.add(StarsUtil.clone(star));
					// ���������·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// ���Ҳ�·�������ж�
		if (col + 1 < StarService.MAX_COLUMN_SIZE) {
			// �������Ҳ�߽������£���ȡ����������ǵ��Ҳ�������
			star = (Star) sList.lookup(row, (col + 1));
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б���
					clearStars.add(StarsUtil.clone(star));
					// �������Ҳ�·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// ���Ϸ�·�������ж�
		if (row - 1 >= 0) {
			// �������Ϸ��߽������£���ȡ����������ǵ��Ϸ�������
			star = (Star) sList.lookup((row - 1), col);
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б���
					clearStars.add(StarsUtil.clone(star));
					// �������Ϸ�·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// ���·�·�������ж�
		if (row + 1 < MAX_ROW_SIZE) {
			// �������·��߽������£���ȡ����������ǵ��·�������
			star = (Star) sList.lookup((row + 1), col);
			// �Ѿ����������������ڽ��������е��������б��л���null��ʾ
			// �Ѿ���������������������б����Ѿ����ڵ������������ظ��жϣ�����������ѭ����
			if (star != null && !clearStars.existed(star)) {
				if (star.getType() == type) {
					// ��������������ж����ݱ���һ��ʱ�������б���
					clearStars.add(StarsUtil.clone(star));
					// �������·�·�������жϡ�
					findStarsByPath(star, sList, clearStars);
				}
			}
		}

		// �����ĸ��ж϶����������ʾ���ܶ�û���������ˣ���ô�����ݹ鷽����
	}

	/**
	 * �û���������ǣ���ȡ���������������������б�
	 * 
	 * @param base
	 *            ���û������������
	 * @param sList
	 *            ��ǰ���������ݵ��б�
	 * @return ��Ҫ�����������
	 */
	@Override
	public StarList tobeClearedStars(Star base, StarList mCurrent) {

		// ���ڱ���������������
		StarList clearStars = new StarList();

		// �ӵ�ǰ�б��л�ȡָ������ָ���е������ǣ�base�����ǣ�
		// ������������Ϊ������󱣴����б���
		// ע�⣺���д�����������Ƕ�Ӧ����ԭʼ�Ľ����������б���
		clearStars.add(base);

		// �Ա����������Ϊ���������ҡ����²�ͬ·��Ѱ����ͬ���ͣ���ɫ���Ĵ����������
		findStarsByPath(base, mCurrent, clearStars);

		if (clearStars.size() == 1)
			clearStars.clear();

		if (logger.isDebugEnabled())
			logger.debug("��������������ڴ��б�:" + clearStars);

		return clearStars;
	}

	/**
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(���޴�ֱ�б���������)<br>
	 * �ù��̶ܹ������������������֮������
	 * 
	 * @param clearStars
	 *            ��������������б����Դ���Ϊ�ж����ƶ������ǵĻ�����
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
	 * @return ���ƶ��������б�
	 */
	/*****************PRJ-BU2-JAVA-012 Task3 ��3/3 Start ��*****************/
	public StarList getYMovedStars(StarList clearStars,
			StarList currentStarList) {
		StarList movedStar = new StarList();
			 int column = 0;
			 int yDis = 0;
			 //StarsUtil.sort(clearStars);
			 Map<Integer,StarList> map = StarsUtil.group(clearStars);
			 Iterator iterator = map.keySet().iterator();//��ȡgroup���صġ�Map��������Key�ĵ�������Iterator��
			 while(iterator.hasNext()){
				 yDis = 0;
				column = (int)iterator.next();
			    clearStars = map.get(column);
				//���жϡ����ƶ������ǡ�����ʼλ�ñ����޸�Ϊ��ѭ����ȡ��ÿһ�С�����������ǡ����ϵ����һ��Ԫ�ص���ֵ��
			 Star star =  clearStars.get(clearStars.size() - 1);
			for(int i=star.getPosition().getRow() ;i>=0 ;i--){
				Star preStar = currentStarList.lookup(i, column);
				if(preStar == null){
					break;
				}
				else if(clearStars.existed(preStar)){
					yDis +=1;
				}
				else{
					
					Position p1 = new Position(preStar.getPosition().getRow(),preStar.getPosition().getColumn());
					Position p2 = new Position(preStar.getPosition().getRow() + yDis, preStar.getPosition().getColumn());
					MovedStar nextStar = new MovedStar(p1,preStar.getType(),p2);
					movedStar.add(nextStar);
				}
				
			}

}
			
			return movedStar;
			/************ PRJ-BU2-JAVA-010 Task3 ��3/3 end��*****************/
		


		
		
		
	}
	/*****************PRJ-BU2-JAVA-012 Task3 ��3/3 End ��*****************/

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
	 * @return true:��Ȼ��δ������������,false:û��δ������������
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {

		// �������������б�
		StarList clearStars = new StarList();

		for (int i = 0; i < currentStarList.size(); i++) {

			Star star = currentStarList.get(i);

			if (star != null)
				findStarsByPath(star, currentStarList, clearStars);

			// ����������������б�������0�����ʾ���п������������ǣ�����true
			if (clearStars.size() > 0)
				return true;
		}

		if (logger.isDebugEnabled())
			logger.debug("�����ڿ������������Ǹ���=" + getLeftStarNum(currentStarList));

		return false;
	}

	/**
	 * ��ȡʣ�������Ǹ���
	 * 
	 * @param mCurretStars
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
	 * @return ʣ�������Ǹ���
	 * */
	private int getLeftStarNum(StarList currentStarList) {
		int leftStar = 0;
		// �����������б����Ѳ�Ϊnull�������Ǽ�Ϊʣ��������
		for (int i = 0; i < currentStarList.size(); i++) {
			if (currentStarList.get(i) != null)
				leftStar++;
		}
		if (logger.isDebugEnabled())
			logger.debug("��ʣ��δ����������������Ϊ" + leftStar);
		// ����ʣ����������Ŀ
		return leftStar;
	}

	/**
	 * ��ȡ�޷������������б�
	 * 
	 * @param curretStars
	 *            ��ǰ�����Ľ����������б����Ѿ�����������������null��ʾ��
	 * @return �޷������������б�
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		StarList awardStarList = new StarList();

		// ����curretStars���Ѳ�Ϊnull�������Ǽӵ������������б���
		for (int i = 0; i < curretStars.size(); i++) {
			// tempStar = curretStars.get(i);
			if (curretStars.get(i) != null) {
				awardStarList.add(StarsUtil.clone(curretStars.get(i)));
			}
		}

		if (logger.isDebugEnabled())
			logger.debug("��ʣ��δ����������������Ϊ" + awardStarList);
		// ���ؽ����������б�
		return awardStarList;

	}

}