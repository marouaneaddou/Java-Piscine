class Program {
    public static void main(String[] args)
    {
        int nb = 479598;
        int sum = 0;
        sum += nb % 10;
        nb = nb / 10;
        sum += nb % 10;
        nb = nb / 10;
        sum += nb % 10;
        nb = nb / 10;
        sum += nb % 10;
        nb = nb / 10;
        sum += nb % 10;
        nb = nb / 10;
        sum += nb % 10;
        nb = nb / 10;
        System.out.println(sum);
    }
}