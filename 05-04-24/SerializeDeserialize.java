package javaBasics.date_05_04_24;

class SerializeDeserialize {

    static String serialize(String str[], int ln)
    {
        String temp = "";
        for (int i = 0; i < ln; i++) {
            int len = str[i].length();
            temp = temp + str[i];
            temp = temp + len + "~";
        }
        return temp;
    }
    static void deserialized(String str, String deserialize[], int ln)
    {
        int len = 0, pos = 0;
        String temp = "";
        int i = 0;
        while (pos > -1) {
            pos = str.indexOf("~", pos+1);
            if (pos > 0) {
                len = str.charAt(pos-1) - '0';
                temp = temp + str.substring(pos + 1, pos+len+1);
                deserialize[i++] = temp;
                temp = "";
            }
        }
    }

    public static void main (String[] args) {
        String str[] = { "scaler", "academy"};

        int n = str.length;
        String serializedstr = serialize(str, n);
        System.out.println(serializedstr);

    }
}
