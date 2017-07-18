package top.letsgogo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.letsgogo.controller.MainController;

/**
 * @author panteng
 * @description
 * @date 17-7-8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainController.class)
public class DialogueServiceTest {
    @Autowired
    DialogueService dialogueService;

    @Test
    public void testMsgHandler() {
        dialogueService.msgHandler("今天天气怎么样?");
        dialogueService.msgHandler("今天是什么样的天气?");
        dialogueService.msgHandler("明天的天气预报怎么说?");
        dialogueService.msgHandler("石家庄昨天下雪了吗?");
    }

}
