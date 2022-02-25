package programmers.level2.skilltree;

public class SkillTree {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println("answer = " + answer);
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree : skill_trees){
            String[] temp = skillTree.split("");
            for(int i=0;i<temp.length;i++){
                if(!skill.contains(temp[i])){
                    skillTree = skillTree.replace(temp[i], "");
                }
            }
            if(skill.indexOf(skillTree)==0) answer++;
        }

        return answer;
    }
}