package com.company.stepik.exLog;

class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();

        System.out.println(booleanExpression(false, true, true, true));


        tryTest();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        // ...
        String name = String.valueOf(new Object() {
        }.getClass().getEnclosingMethod());
        String str = Thread.currentThread().getStackTrace()[1].getClassName();

        StackTraceElement stackTraceElements[] = (new Throwable()).getStackTrace();
        String methodName = stackTraceElements[1].toString();

        return methodName;
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        boolean[] boolAr = new boolean[]{a, b, c, d};
        int i = 0;
        for (boolean e : boolAr) {
            if (e == true)
                i++;
        }
        if (i == 2) {
            return true;
        }
        return false;
    }

    public static void tryTest() {
        try {
//            System.exit(0);
        } catch (Exception e) {
        } finally {
            throw new Error();
        }
    }
}
