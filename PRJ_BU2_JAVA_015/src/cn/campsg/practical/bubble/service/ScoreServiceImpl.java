package cn.campsg.practical.bubble.service;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * ��������������Ϊ�����ṩ���¹���<br>
 * 1. ����ؿ�ͨ�ط���<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 1.1
 *
 */
public class ScoreServiceImpl implements ScoreService {

	/* ���������ļ������� */
	private Configuration mConfiguration = null;

	/* �����ж���ǰ�ؿ�����ϲͨ�ء��Ƿ��Ѿ���֪ͨ��һ�� */
	public static int mLevelCounter = 1;

	public ScoreServiceImpl() {
		mConfiguration = new Configuration();
	}

	/**
	 * ����Ҫ�л��Ĺؿ��ȼ���ȡĿ�����
	 * 
	 * @param ��һ�عؿ�
	 * @return ������ĵ÷�
	 * 
	 */
	@Override
	public int nextScoreByLevel(int nextLevel) {

		return mConfiguration.nextLevelScore(nextLevel);
	}
	
	/**
	 * ��õ�ǰ�ص�ͨ�ط���
	 * 
	 * @return ������ĵ÷�
	 * 
	 */
	@Override
	public int getCurrentLevelScore() {

		return mConfiguration.getScore().getLevelScore();
	}

	/**
	 * ���ݵ�����ȡ�Ĵ����������Ǽ�����÷�<br>
	 * ����������������÷ֹ���: <br>
	 * 1. ������1�������� --> ��5�� <br>
	 * 2. ������2�������� --> ��15�� <br>
	 * 3. ������3�������� --> ��25�� <br>
	 * 4. ������4�������� --> ��35��<br>
	 * 5. ������5�������� --> ��45��<br>
	 * 
	 * @param stars
	 *            ���ݵ�����ȡ�Ĵ����������Ǽ���
	 * @return ������ĵ÷�
	 * */
	@Override
	public int getScoreByStars(StarList stars) {

		return getScoreByStars(stars.size());
	}

	/**
	 * ���ݵ�����ȡ�Ĵ���������������������÷�<br>
	 * ����������������÷ֹ���: <br>
	 * 1. ������1�������� --> ��5�� <br>
	 * 2. ������2�������� --> ��15�� <br>
	 * 3. ������3�������� --> ��25�� <br>
	 * 4. ������4�������� --> ��35��<br>
	 * 5. ������5�������� --> ��45��<br>
	 * 
	 * @param stars
	 *            ���ݵ�����ȡ�Ĵ���������������
	 * @return ������ĵ÷�
	 * 
	 * */
	@Override
	public int getScoreByStars(int stars) {
		/***********PRJ-BU2-JAVA-015 Task1 ��1/3 Start�� ***********/
		int result = 0;
		result = LOWER_SCORE *stars * stars;
		
		return result;
		/***********PRJ-BU2-JAVA-015 Task1 ��1/3 End�� *************/
	}

	/**
	 * �޿������������ǣ�����ʣ���޿��������ݿ��Ի�ý�������
	 * 
	 * �޿����������ǽ����÷ֹ���: <br>
	 * 1. ʣ��1�������� --> ����1620�� <br>
	 * 2. ʣ��2�������� --> ����1280�� <br>
	 * 3. ʣ��3�������� --> ����980�� <br>
	 * 4. ʣ��4�������� --> ����720�� <br>
	 * 5. ʣ��5�������� --> ����500�� <br>
	 * 
	 * @param awardStarNumʣ�������Ǹ���
	 * @return ʣ�������ǽ�������
	 * */
	@Override
	public int getAwardScore(int leftStarNum) {
		/***********PRJ-BU2-JAVA-015 Task2 ��2/3 Start�� ***********/
		int result = 0;
		if(leftStarNum <10){
			 result = LOWER_AWARD_SCORE * (AWARD_LIMIT - leftStarNum) * (AWARD_LIMIT - leftStarNum);
			
		}else{
			result = 0;
		}
		
		return result;
		/***********PRJ-BU2-JAVA-015 Task2 ��2/3 End�� *************/
	}

	/**
	 * �жϵ�ǰ�����Ƿ��Ѿ��ﵽ������һ�ص�Ҫ��
	 * 
	 * @param score ��ǰ�÷�
	 * @return true:����������һ�أ�false:������������һ��
	 */
	@Override
	/***********PRJ-BU2-JAVA-015 Task3 ��3/3 Start�� ***********/
	public boolean isChangeLevel(int score) {
		int levelScore = mConfiguration.getScore().getLevelScore();
		
		return (score >= levelScore) ? true : false;

		
	}

	/**
	 * ���ݵ÷���ؿ����ж��Ƿ���Ҫ���֡���ϲͨ�ء�<br>
	 * ע�⣺��һ���У�����ϲͨ�ء����ҽ�����ʾһ�Ρ�
	 * 
	 * @param currentLevel ��ǰ�ؿ��ȼ�   
	 * @param score ��ǰ�÷�
	 * @return true:֪ͨ��false:��֪ͨ
	 */
	int level = 1;
	@Override
	
	public boolean isNoticePassLevel(int currentLevel, int score) {
		isChangeLevel(score);
		
		if(level == currentLevel){
			level ++;
			return true;
		}
		else{
			return false;
		}
		
		
	}

	/***********PRJ-BU2-JAVA-015 Task3 ��3/3 End�� *************/
}