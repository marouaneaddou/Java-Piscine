/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Program.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: maddou <maddou@student.42.fr>              +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2026/07/17 16:26:44 by maddou            #+#    #+#             */
/*   Updated: 2026/07/30 11:49:52 by maddou           ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.Scanner;

class Program {
    private static final int        MAX_STUDENT                 =   10;
    private static final String[]   STUDENT                     =   new String[MAX_STUDENT];
    private static final int        MAX_SESSION_IN_WEEK         =   10;
    private static final int[][]    TIME_DAY                    =   new int[MAX_SESSION_IN_WEEK][2];
    private static final String[][] ATTENDANCE_NAME_STATUS      =   new String[MAX_STUDENT * MAX_SESSION_IN_WEEK * 4][2];
    private static final int[][]    ATTENDANCE_TIME_DAY         =   new int[MAX_STUDENT  * MAX_SESSION_IN_WEEK * 4][2];
    private static final String[]   days_of_week                =   { "TU", "WE", "TH", "FR", "SA", "SU", "MO" };

    private static int day_to_index( String day ) {
        for ( int i = 0; i <= 6; i++ ) {
            if ( days_of_week[i].equals( day )) return i;
        }
        return 0;
    }

    private static int string_to_int( String word ) {
        int nb = 0;
        char[] chars = word.toCharArray();
        for ( int i = 0; i < word.length(); i++ ) {
            nb = nb * 10 + chars[i] - '0';
        }
        return nb;
    }

    private static String[] split( String line, int size ) {
        String[] words = new String[size];
        char[] chars = line.toCharArray();
        String word = "";
        for ( int i = 0, iw = 0; i < line.length(); i++  ) {
            if ( chars[i] == ' ' ) {
                words[iw++] = word; 
                word = "";
            }
            else word += chars[i];
        }
        if ( word.length() > 0 ) words[ size - 1 ] = word;
        return words;
    }
    
    private static void swap( int[] tmp, int i , int j ) {
        tmp[0] = TIME_DAY[i][0];
        tmp[1] = TIME_DAY[i][1];
        TIME_DAY[i][0] = TIME_DAY[j][0];
        TIME_DAY[i][1] = TIME_DAY[j][1];
        TIME_DAY[j][0] = tmp[0];
        TIME_DAY[j][1] = tmp[1];
    }
    
    private static void sort_time_day( int size_of_time_day ) {
        int[] tmp = new int[2];
        // System.out.println(size_of_time_day);
        for ( int i = 0; i < size_of_time_day; i++ ) {
            for ( int j = i + 1; j < size_of_time_day; j++ ) {
                if ( TIME_DAY[i][1] > TIME_DAY[j][1] ) swap( tmp, i, j);
                else if ( TIME_DAY[i][1] == TIME_DAY[j][1] && TIME_DAY[i][0] > TIME_DAY[j][0]) swap( tmp, i, j);
            }
        }
    }
    
    private static void printTable( int size_students, int size_time_day, int size_attendance) {
        System.out.printf("%-10s", "");
        int dayIndex = 0;
        for (int day = 1; day <= 30; day++) {
            for (int i = 0; i < size_time_day; i++) {
                if (TIME_DAY[i][1] == dayIndex) {
                    System.out.printf("|%-10s",
                            TIME_DAY[i][0] + ":00 "
                            + days_of_week[dayIndex]
                            + " " + day);
                }
            }
            dayIndex++;
            if (dayIndex == 7)
                dayIndex = 0;
        }
        System.out.println("|");
        for (int s = 0; s < size_students; s++) {
            System.out.printf("%-10s", STUDENT[s]);
            dayIndex = 0;
            for (int day = 1; day <= 30; day++) {
                for (int i = 0; i < size_time_day; i++) {
                    if ( TIME_DAY[i][1] == dayIndex ) {
                        int status = 0;
                        for (int a = 0; a < size_attendance; a++) {
                            if ( ATTENDANCE_NAME_STATUS[a][0].equals(STUDENT[s] )
                                && ATTENDANCE_TIME_DAY[a][0] == TIME_DAY[i][0]
                                && ATTENDANCE_TIME_DAY[a][1] == day) {
                                
                                status = ATTENDANCE_NAME_STATUS[a][1].equals( "HERE") ? 1 : -1;
                            }
                        }
                        if (status != 0) {
                            System.out.printf("|%10s", status);
                        } else {
                            System.out.printf("|%10s", "");
                        }
                    }
                }
                dayIndex++;
                if (dayIndex == 7)
                    dayIndex = 0;
            }
            System.out.println("|");
        }
    }
    
    private static boolean hasWhitespace( String line ) {
        for ( char c : line.toCharArray() ) {
            if ( c == ' ' ) return true;
        }
        return false;
    }
    
    public static void main ( String[] args ) {
        String line;
        Scanner scanner =  new Scanner( System.in );
        int size_students       = 0;
        int size_time_day       = 0;
        int size_attendance     = 0;
        int cycle               = 0;
        System.out.printf("-> ");
        while ( scanner.hasNextLine() ) {
            
            line = scanner.nextLine();
            if ( cycle == 0 && size_students == 10 ) {
                System.out.println( "Maximum number of students in the timetable is 10" );
                System.exit(-1);
            }
            else if ( cycle == 1 && size_time_day == 10 ) {
                System.out.println( "Maximum number of session in the week is 10" );
                System.exit(-1);
            }
            else if ( cycle == 2 && size_attendance == MAX_STUDENT * MAX_SESSION_IN_WEEK * 4) {
                System.out.printf( "The maximum number of attendance records allowed per month is %d\n", MAX_STUDENT * MAX_SESSION_IN_WEEK * 4 );
                System.exit(-1);
            }
            if ( line.equals(".") ) {
                cycle++;
                if ( cycle == 3 ) break;
                else 
                    System.out.printf("-> ");
                continue;
            }
            if ( cycle == 0 ) {
                if ( line.length() > 10 ) {
                    System.out.println( "The name cannot be longer than 10 characters." );
                    System.exit(-1);
                }
                else if ( hasWhitespace( line ) ) {
                    System.out.println( "The name cannot contain spaceses" );
                    System.exit(-1);
                }
                STUDENT[size_students++] = line;
            }
            else if ( cycle == 1 ) {
                String[] words = split( line, 2 );
                TIME_DAY[size_time_day][0] = string_to_int( words[0] );
                TIME_DAY[size_time_day++][1] = day_to_index( words[1] );
            }
            else if ( cycle == 2 ) {
                String[] words = split( line, 4 );
                ATTENDANCE_NAME_STATUS[size_attendance][0]                      =   words[0];
                ATTENDANCE_NAME_STATUS[size_attendance][1]                      =   words[3];
                ATTENDANCE_TIME_DAY[size_attendance][0]                         =   string_to_int(words[1]);
                ATTENDANCE_TIME_DAY[size_attendance++][1]                       =   string_to_int(words[2]);
            }
            System.out.printf("-> ");
        }
        sort_time_day( size_time_day );
        printTable( size_students, size_time_day, size_attendance );
        scanner.close();
    }
}
