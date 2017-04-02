package io.ramanan.hdfs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by ramanan on 3/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaTest {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	//@Autowired
	//private Listener listener;

	@Test
	public void test() throws InterruptedException {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic1", "Ramanan Pathmaraj");
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable throwable) {
				System.out.println("Failed");
			}

			@Override
			public void onSuccess(SendResult<String, String> stringStringSendResult) {
				System.out.println("Success");
			}
		});

		System.out.println(Thread.currentThread().getId());
		//assertThat(this.listener.latch.await(60, TimeUnit.SECONDS)).isTrue();
	}

}
