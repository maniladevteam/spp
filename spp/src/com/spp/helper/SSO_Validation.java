


package com.spp.helper;


import java.util.*;

import java.security.*;



public class SSO_Validation {


    /**

    * Checks for 5 minute trust

    * @param uid

    * @return

    */

    public boolean validateTime(String time)

    {

        Calendar curtime = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        Calendar reqtime = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        Date d1;

        Date d2;

        long dif=300000;

        long timedif;



        if(time.length() >= 19)

        {

            //GRAB DATES AND TIME FROM URL

            String yyyy = time.substring(0,4);

            String mm = time.substring(5,7);

            String dd = time.substring(8,10);

            String hr = time.substring(11,13);

            String min = time.substring(14,16);

            String sec = time.substring(17,19);



            //WRAP STRINGS INTO INTEGER OBJECTS

            Integer year = new Integer(yyyy);

            Integer month = new Integer(mm);

            Integer day = new Integer(dd);

            Integer hour = new Integer(hr);

            Integer minute = new Integer(min);

            Integer second = new Integer(sec);



            //SET CALENDAR TIME FOR REQUEST

            reqtime.set(year.intValue(),(month.intValue()-1),day.intValue(),hour.intValue(),minute.intValue(),second.intValue());



            d1 = curtime.getTime();

            d2 = reqtime.getTime();



            timedif = Math.abs(d1.getTime()-d2.getTime());



            //CHECK TO SEE IF THERE IS FIVE MINUTES DIFFERENCE

            if(timedif<=dif)

            {

                return(true);

            }

            else

            {

                return(false);

            }

        } // CLOSES TIME FIELD IF

        else

        {

            // THE TIME PARAMETER IS INCORRECTLY FORMATTED

            return(false);

        }

    } // CLOSES VALIDATE TIME







    /**

    * Creates md5 digest from posted credentials and compare to validate user

    * @param empID

    * @param time

    * @param md5

    * @param md5key

    * @return

    */

    public boolean verify(String empID, String time, String md5, String md5key)

    {

        byte[] info = null;

        byte[] hash = null;

        StringBuffer hexBuffer = new StringBuffer();

        String empInfo = empID + time + md5key;



        MessageDigest md = null;



        //Create an instance MD5 Digest instance

        try

        {

            md = MessageDigest.getInstance("MD5");

            info = empInfo.getBytes();

            hash = md.digest(info);

        }

        catch(java.security.NoSuchAlgorithmException e)

        {

            e.printStackTrace();

        }



        //Convert buffer to string

        hexBuffer = hexDigit(hash);

        String empdata = hexBuffer.toString();



        //CHECK TO SEE IF MD5 DATA IS CORRECT

        if(md5.equals(empdata))

        {

            return(true);

        }

        else

        {

            return(false);

        }

    }







    /**

    * CONVERTS MD5 VALUE TO HEX VALUE

    * @param hash

    * @return

    */

    private StringBuffer hexDigit(byte[] hash)

    {

        StringBuffer s = new StringBuffer();



        byte x;

        char c;



        for(int i=0;i<hash.length;i++)

        {

            x = hash[i];



            c = (char) ((x >> 4) & 0xf);



            if(c > 9)

                {c = (char) ((c - 10) + 'a');}

            else

                {c = (char) (c + '0');}



            s.append(c);

            c = (char) (x & 0xf);



            if(c > 9)

                {c = (char)((c-10) + 'a');}

            else

                {c = (char)(c + '0');}



            s.append(c);

        }



        return s;

    }

}
