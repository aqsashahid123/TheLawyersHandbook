package com.thelawyershandbook.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


/**
 * Created by Faraz on 11/30/2015.
 */
public class DateConversion {
    public static String time = "";

    public static String UTC(String date) {
        String myDate = "";
        try {
            Calendar calendar = Calendar.getInstance();
            TimeZone tz = TimeZone.getTimeZone("UTC");
            int gmtOffset = TimeZone.getDefault().getRawOffset() + TimeZone.getDefault().getDSTSavings();
            DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.UK);
            utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));


            Date dateee = utcFormat.parse(date);


            myDate = dateee.toString().substring(11, 13);
            int dt = Integer.parseInt(myDate);
            myDate = dt + dateee.toString().substring(13, 16);
        } catch (Exception e) {

        }

        //Log.e("Date", myDate);
        return myDate;
    }

    public static String UTCDate(String date) {
        String myDate = "";
        try {
            date.replace("T", " ");
            DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
            utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Log.e("Test", date);
            Date dateee = utcFormat.parse(date);
            Log.e("CTest", dateee.toString());
            myDate = dateee.toString().substring(0, 9) + " " + dateee.toString().substring(11, 18);

        } catch (Exception e) {

        }

        //Log.e("Date", myDate);
        return myDate;
    }

    public static String ParseTime(String myDate) {
        String date = myDate.substring(0, 2);
        int dt = Integer.parseInt(date);
        if (dt > 12) {
            dt = dt - 12;
            if (dt <= 9) {

                myDate = "0" + dt + myDate.toString().substring(2,5) + " PM";
            } else {

                myDate = dt + myDate.toString().substring(2,5) + " PM";
            }
        } else if (dt == 0) {
            myDate = "12:00 AM";
        } else {
            if (dt <= 9) {

                myDate = "0" + (dt) + myDate.toString().substring(2,5) + " AM";
            } else {

                myDate = (dt) + myDate.toString().substring(2,5) + " AM";
            }

        }
        Log.e("MyDate", myDate);
        return myDate;
    }

    public static String Mydate(String myday) {

        Calendar calendar = Calendar.getInstance();
        TimeZone tz = calendar.getTimeZone();
        String currentDate, yesterday, twoday, threeday, fourday, fiveday, sixday, weekday;
        DateFormat utcFormat = new SimpleDateFormat("yyyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.UK);
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat newDateFormat2 = new SimpleDateFormat("MMM dd, yyyy");
        try {
            Date date = utcFormat.parse(myday);

            Log.e("DAYSINMILI", getDisplayableTime(date.getTime()));

            myday = getDisplayableTime(date.getTime());
            myday = newDateFormat2.format(date);
            currentDate = newDateFormat2.format(new Date());
            calendar.add(Calendar.DATE, -1);
            yesterday = newDateFormat2.format(calendar.getTime());


            if (currentDate.equals(myday)) {
                myday = "Today";
            }
        } catch (Exception e) {
            Log.e("Date2", e.getMessage());
        }


        return myday;
    }

    public static String Mydate2(String myday) {
        myday=UtcToLocal(myday);
        String currentDate;
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat newDateFormat2 = new SimpleDateFormat("MMM dd, yyyy");
        try {
            currentDate = newDateFormat2.format(new Date());
            Date date = utcFormat.parse(myday);

            myday = newDateFormat2.format(date);

            if (currentDate.equals(myday)){
                myday = "Today";
            }
            Log.e("Date2", myday);
        } catch (Exception e) {
            Log.e("Date2", e.getMessage());
        }


        return myday;
    }
    public static Date StringToDate(String myday) {
        Date date = null;
        myday = UtcToLocal(myday);
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            date = dateFormat.parse(myday);
        }catch (Exception e){

        }

        return date;
    }
    public static Date StringToDate2(String myday) {
        Date date = null;
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            date = dateFormat.parse(myday);
        }catch (Exception e){

        }

        return date;
    }
    public static Date StringToDate_yyyy_MM_dd(String myday) {
        Date date = null;
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = dateFormat.parse(myday);
        }catch (Exception e){

        }

        return date;
    }
    public static String MydateTime(String myday) {
        myday=UtcToLocal(myday);
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat newDateFormat2 = new SimpleDateFormat("hh:mm");
        try {
            Date date = utcFormat.parse(myday);

            myday = newDateFormat2.format(date);


        } catch (Exception e) {
            Log.e("Date2", e.getMessage());
        }


        return myday;
    }
    public static String UtcToLocal(String myday) {

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date curDate=formatter.parse(myday);
            formatter.setTimeZone(TimeZone.getDefault());
            String formattedDate = formatter.format(curDate);
            myday=formattedDate;
        }catch (Exception e){
            Log.e("Converter",e+"");
        }


        return myday;
    }


    public static String getDisplayableTime(long delta) {
        long difference=0;
        Long mDate = System.currentTimeMillis();

        if(mDate > delta)
        {
            difference= mDate - delta;
            final long seconds = difference/1000;
            final long minutes = seconds/60;
            final long hours = minutes/60;
            final long days = hours/24;
            final long months = days/31;
            final long years = days/365;

            if (seconds < 0)
            {
                return "not yet";
            }
            else if (seconds < 60)
            {
                return seconds == 1 ? "one second ago" : seconds + " seconds ago";
            }
            else if (seconds < 120)
            {
                return "a minute ago";
            }
            else if (seconds < 2700) // 45 * 60
            {
                return minutes + " minutes ago";
            }
            else if (seconds < 5400) // 90 * 60
            {
                return "an hour ago";
            }
            else if (seconds < 86400) // 24 * 60 * 60
            {
                return hours + " hours ago";
            }
            else if (seconds < 172800) // 48 * 60 * 60
            {
                return "yesterday";
            }
            else if (seconds < 2592000) // 30 * 24 * 60 * 60
            {
                return days + " days ago";
            }
            else if (seconds < 31104000) // 12 * 30 * 24 * 60 * 60
            {

                return months <= 1 ? "one month ago" : days + " months ago";
            }
            else
            {

                return years <= 1 ? "one year ago" : years + " years ago";
            }
        }
        return null;
    }



    public static String AddBookingDate(String myday) {

        Calendar calendar = Calendar.getInstance();
        TimeZone tz = calendar.getTimeZone();
        String currentDate;
        DateFormat utcFormat = new SimpleDateFormat("yyyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.UK);
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat newDateFormat2 = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
        try {
            Date date = utcFormat.parse(myday);


            myday = newDateFormat2.format(date);


        } catch (Exception e) {

        }


        return myday;
    }
    public static String AddInvitationDate(String myday) {
        myday=UtcToLocal(myday);
        Calendar calendar = Calendar.getInstance();
        TimeZone tz = calendar.getTimeZone();
        String currentDate;
        DateFormat utcFormat = new SimpleDateFormat("yyyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat newDateFormat2 = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        try {
            Date date = utcFormat.parse(myday);


            myday = newDateFormat2.format(date);


        } catch (Exception e) {

        }


        return myday;
    }
    public static String AddDate(String myday) {

        Calendar calendar = Calendar.getInstance();
        TimeZone tz = calendar.getTimeZone();
        String currentDate;
        DateFormat utcFormat = new SimpleDateFormat("yyyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.UK);
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        SimpleDateFormat newDateFormat2 = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
        try {
            Date date = utcFormat.parse(myday);


            myday = newDateFormat2.format(date);


        } catch (Exception e) {

        }


        return myday;
    }
    public static String DAYname(String datestr) {
        try {
            SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inFormat.parse(datestr);
            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
            datestr = outFormat.format(date);
        } catch (Exception e) {

        }

        return datestr;
    }

    public static Date StrToDate(String datestr) {
        Date date = null;
        try {
            SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = inFormat.parse(datestr);

        } catch (Exception e) {

        }

        return date;
    }



    public static String TimeDifference(Date c_date, Date saved_date) {
        long seconds = 0;
        long minutes = 0;
        long hours = 0;
        long diffInMillisec = c_date.getTime() - saved_date.getTime();
        long diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec);
        seconds = diffInSec % 60;
        diffInSec /= 60;
        minutes = diffInSec % 60;
        diffInSec /= 60;
        hours = diffInSec % 24;
        diffInSec /= 24;
        String Vale = String.valueOf(minutes);
        return Vale;
    }

    public static String TimeDifferenceHours(Date c_date, Date saved_date) {
        String Vale = "";
        try {

            long seconds = 0;
            long minutes = 0;
            long hours = 0;
            long days = 0;
            long diffInMillisec = c_date.getTime() - saved_date.getTime();
            long diffInSec = TimeUnit.MILLISECONDS.toSeconds(diffInMillisec);
            seconds = diffInSec % 60;
            diffInSec /= 60;
            minutes = diffInSec % 60;
            diffInSec /= 60;
            hours = diffInSec % 24;
            diffInSec /= 24;
            days = diffInMillisec / (24 * 60 * 60 * 1000);
            Vale = String.valueOf(days) + String.valueOf(hours);
        } catch (Exception e) {

        }

        return Vale;
    }

    public static List<Date> firstDateOfMonth(Date date, int numberOfMonth) {

        List<Date> dateList = new ArrayList<>();

        Calendar aCalendar = Calendar.getInstance();
        aCalendar.add(Calendar.MONTH, -numberOfMonth);
        aCalendar.set(Calendar.DATE, 1);

        Date firstDateOfPreviousMonth = aCalendar.getTime();
        aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date lastDateOfPreviousMonth = aCalendar.getTime();

        dateList.add(firstDateOfPreviousMonth);
        dateList.add(lastDateOfPreviousMonth);

        return dateList;
    }
    public static String WeekDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz ");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

//        cal.set(Calendar.DATE, 1);
//        cal.set(Calendar.HOUR_OF_DAY, 00);
//        cal.set(Calendar.MINUTE, 00);
//        cal.set(Calendar.SECOND, 00);
        Date firstDateOfPreviousMonth = cal.getTime();

//        cal.set(Calendar.DATE, 7);
//        cal.set(Calendar.HOUR_OF_DAY, 23);
//        cal.set(Calendar.MINUTE, 59);
//        cal.set(Calendar.SECOND, 59);
        cal.add(Calendar.DAY_OF_YEAR, 7);
        Date lastDateOfPreviousMonth = cal.getTime();
        Log.e("LastDAY", formatter.format(lastDateOfPreviousMonth).toString());
        Log.e("StartDAY", formatter.format(firstDateOfPreviousMonth).toString());
        String completeDate = "&startDate=" + formatter.format(firstDateOfPreviousMonth).toString() +
                "&endDate=" + formatter.format(lastDateOfPreviousMonth).toString();

        return completeDate;
    }

    public static String DayDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz ");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

//        cal.set(Calendar.DATE, 1);
//        cal.set(Calendar.HOUR_OF_DAY, 00);
//        cal.set(Calendar.MINUTE, 00);
//        cal.set(Calendar.SECOND, 00);
        Date firstDateOfPreviousMonth = cal.getTime();

        cal.set(Calendar.DATE, 7);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        Date lastDateOfPreviousMonth = cal.getTime();
        Log.e("LastDAY", formatter.format(lastDateOfPreviousMonth).toString());
        Log.e("StartDAY", formatter.format(firstDateOfPreviousMonth).toString());
        String completeDate = "&startDate=" + formatter.format(firstDateOfPreviousMonth).toString() +
                "&endDate=" + formatter.format(firstDateOfPreviousMonth).toString();

        return completeDate;
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(date);
            cal.add(Calendar.DATE, -days);
        } catch (Exception e) {

        }

        return cal.getTime();
    }

    public static String addDays2(String Date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(dateFormat.parse(Date));
            cal.add(Calendar.DATE, 1);
        } catch (Exception e) {

        }

        return dateFormat.format(cal.getTime());
    }


    public static boolean checkDateValidity(Calendar calendarCurrent, Calendar calendar){
        boolean isValid = false;
        int y1, m1, d1, y2, m2, d2;
        y1 = calendarCurrent.get(Calendar.YEAR);
        y2 = calendar.get(Calendar.YEAR);
        m1 = calendarCurrent.get(Calendar.MONTH);
        m2 = calendar.get(Calendar.MONTH);
        d1 = calendarCurrent.get(Calendar.DAY_OF_MONTH);
        d2 = calendar.get(Calendar.DAY_OF_MONTH);

        boolean sameDay = calendar.get(Calendar.YEAR) == calendarCurrent.get(Calendar.YEAR) &&
                calendar.get(Calendar.DAY_OF_YEAR) == calendarCurrent.get(Calendar.DAY_OF_YEAR);
        if (sameDay){
            return true;
        }else {
            if (calendar.after(calendarCurrent) || calendar.equals(calendarCurrent)){
                return  true;
            }else {
                return false;
            }
        }


    }


    public static String ConverLocalToUTC(String date){
        String returnDate="";
        try {
            Log.e("LocalDate",date);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            formatter.setTimeZone(TimeZone.getDefault());
//            String str=formatter.parse(date).toString();
//            Date dateConverted=formatter.parse(date);
//            String formattedDate = Targetformatter.format(dateConverted);
//            returnDate=formattedDate;
//            Log.e("DateToUTC",str);
//            Log.e("DateToUTCCC",formatter.parse(date)+"");
//            Log.e("DateToUTCCCCCCC",formattedDate);
            Date curDate=formatter.parse(date);
            Log.e("Run","Yes");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            Log.e("Run1","Yes");
            String formattedDate = formatter.format(curDate);
            Log.e("DateToUTCCCCCCCCCC",formattedDate);
            returnDate=formattedDate;
        }catch (Exception e){
            Log.e("Converter",e+"");
        }
     return returnDate;
    }
     public static Calendar getCurruntTime(){
         Calendar c = Calendar.getInstance();
         int seconds = c.get(Calendar.SECOND);
         return c;
    }
    public static int diffrenceTime(String time1, String time2){
        int min =0;
        int hours = 0;
        int  days = 0;
        try{

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date1 = simpleDateFormat.parse(time1);
            Date date2 = simpleDateFormat.parse(time2);
            long difference = date2.getTime() - date1.getTime();

            days = (int) (difference / (1000*60*60*24));
            hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
            min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
            hours = (hours < 0 ? -hours : hours);
            Log.e("hourse",hours+"");
            days = (days < 0 ? -days : days);
            if(days == 0){
                if(hours == 0){
                    min = (min < 0 ? -min : min);
                }else {
                    min = 16;
                }
            }else {
                min = 16;
            }
            Log.e("======= DifMin"," :: "+min);
        }catch (Exception e){
            Log.e("exce in diff",e+"");
        }
      return min;
    }
}



