/**
 *
 */
package com.sukkiri.test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author user2
 *
 */
public class DT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 旧API
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(131662222595L);
		System.out.println(past);

		// 新API
		// 現在時刻を取得
		Instant i = Instant.now();

		// Instantとlong値の相互変換
		Instant i2 = Instant.ofEpochMilli(31920291332L);
		long l = i2.toEpochMilli();

		// ZoneDateTimeの生成
		ZonedDateTime z1 = ZonedDateTime.now(); // 現在日次を取得
		ZonedDateTime z2 = ZonedDateTime.of(2014, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo")); // 東京時間、2014年1月2日3時4分5秒6ナノ秒を指定して取得

		// InstantとZonedDateTimeの相変換
		Instant i3 = z2.toInstant();
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

		// ZonedDateTimeの利用
		System.out.println("東京" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
		System.out.println("ロンドン" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());

		// 同じ瞬間の判定にはisEqualを使う
		if (z2.isEqual(z3)) {
			System.out.println("これらは同じ時間を指しています");
		}

		// localDatetime 私たち普段使うようなタイムゾーンを考慮しない時間
		LocalDateTime l1 = LocalDateTime.now(); // 現在日次を指定
		LocalDateTime l2 = LocalDateTime.of(2014, 1, 1, 9, 5, 0, 0); // 2014年1月1日9時5分0秒0ナノ秒を指定して取得

		// localDateTimeとZonedDateTimeの相互変換
		ZonedDateTime z4 = l2.atZone(ZoneId.of("Europe/London"));
		System.out.println(z4);
		LocalDateTime l3 = z4.toLocalDateTime();
		System.out.println(l3);

		// 文字列からLocalDateを生成
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate d = LocalDate.parse("2011/08/21", f);

		// 千日後を計算する
		d = d.plusDays(1000);
		String str = d.format(f);
		System.out.println("1000日後は" + str);

		// 現在時刻との比較
		LocalDate now2 = LocalDate.now();
		if (now2.isAfter(d)) {
			System.out.println("now2はdより新しい");
		}

		// 日数ベースで期間管Period [時間・分・秒]で収まる期間Duration
		LocalDate d1 = LocalDate.of(2014, 11, 1);
		LocalDate d2 = LocalDate.of(2014, 11, 4);

		// 3日間を表すPeriodを2通りの方法で生成
		Period p1 = Period.ofDays(3);
		Period p2 = Period.between(d1, d2);

		// d2のさらに三日後を計算する
		LocalDate d3 = d2.plus(p2);
		System.out.println(d3);

		DTTest dtTest = new DTTest();
		dtTest.test1();
		dtTest.test2();
	}
}

class DTTest {
	void test1() {
		// 現在時刻をDate型で取得
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		// 取得した日時情報をCalendarにセット
		cal.setTime(now);
		// Calendarから日の情報を取得
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		// 100足してcalendarインスタンスに入れる
		cal.set(Calendar.DAY_OF_MONTH, dayOfMonth + 100);
		//
		Date time = cal.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(sf.format(time));
	}

	void test2() {
		LocalDate now = LocalDate.now();
		LocalDate future = now.plusDays(100);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");
		System.out.println(future.format(f));
	}
}
