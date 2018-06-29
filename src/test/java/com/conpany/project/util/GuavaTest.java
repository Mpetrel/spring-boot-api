package com.conpany.project.util;

import com.conpany.project.Tester;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.junit.Test;

/**
 * @program: spring-boot-api-project-seed
 * @description:
 * @author: Larry
 * @create: 2018-06-29 15:00
 **/
public class GuavaTest extends Tester {

    @Test
    public void md5() {
        HashCode hashCode = Hashing.sha256().hashBytes("123".getBytes());
        System.out.println(hashCode.toString());
    }

    public static void main(String[] args) {
        HashCode hashCode = Hashing.sha256().hashBytes("123".getBytes());
        System.out.println(hashCode.toString().length());
    }

}
