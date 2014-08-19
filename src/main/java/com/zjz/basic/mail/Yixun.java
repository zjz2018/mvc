package com.zjz.basic.mail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Yixun implements Runnable {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Yixun());
		t.start();
		System.out.println("线程开始");
	}
	
	@Override
	public void run() {
		// 南方黑芝麻糊
		String site1 = "http://dwz.cn/mH4Bl";
		// 维达纸
		String site2 = "http://dwz.cn/mESjn";
		// 牙膏
		String site3 = "http://dwz.cn/mH4uj";
		// 雀巢咖啡
		String site4 = "http://dwz.cn/mH4xq";
		// sort_page
		String[] site = new String[] { site1, site2, site3, site4 };
		String[] name = new String[] { "芝麻糊", "维达", "牙膏", "雀巢咖啡" };
		try {
			while (1 == 1) {
				for (int i = 0; i < site.length; i++) {
					
					URI uri = new URI(site[i]);
					URL url = uri.toURL();
					Document doc = Jsoup.parse(url, 5000);
					Elements eles = doc.getElementsByAttributeValueMatching("class", "sort_page_txt");
					 System.out.println(eles);
					if (eles != null) {
						Element div = eles.get(0);
						Node b = div.childNode(1);
						if (i == 2 && b.outerHtml().equals("<b>1</b>")) {
							// 牙膏那个不要
						} else if (b.outerHtml().equals("<b>0</b>")) {
						} else {
							/*System.out.println("yes,立刻邮件通知");
							MailUtils.sendHTML("yixun", String.format(
									"%s有货<br/><a target='_bank' href='%s'>%s有货  %s</a><br/>", name[i], name[i],
									site[i], site[i]));
							System.out.println(name[i]);*/
						}
					}
				}
				Thread.currentThread();
				Thread.sleep(60000);
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
