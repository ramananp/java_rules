package io.ramanan.hdfs;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ramanan on 3/10/17.
 */
public class Listener {

	public final CountDownLatch latch = new CountDownLatch(1);

	@KafkaListener(id = "foo", topics = "topic1", group = "group1")
	public void listen(ConsumerRecord<?, ?> record){
		System.out.println("record = " + record);
		latch.countDown();
	}

}
