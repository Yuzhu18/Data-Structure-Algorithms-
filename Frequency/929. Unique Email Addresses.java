class Solution {
    // local name / domain name 分别处理
    // 利用 split() , replace(), indexOf(), substring()
    //存hashset , return hashset.size()
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for(String e : emails){
            String[] parts = e.split("@");
            String local = parts[0].replace(".", "");
            int i = local.indexOf("+");
            String email = local.substring(0, i) + "@" + parts[1];
            unique.add(email);
        }
        
        return unique.size();
    }
}



