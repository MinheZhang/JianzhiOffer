class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            if (c == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}