public class Mid4 {

    public static void main(String[] args) {
        String email = "zubas123@gmail.com";
        int atIndex = email.indexOf('@');
        String username = email.substring(0, atIndex);
        System.out.println("Username: " + username);
    }
}


