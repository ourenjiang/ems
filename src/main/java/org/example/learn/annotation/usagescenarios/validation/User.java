package org.example.learn.annotation.usagescenarios.validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//public class User {
////    @NotNull(message = "ID不能为空")
//    @NotNull(message = "ID不能为空")
//    private Long id;
//    @Size(min = 2, max = 20, message = "姓名长度需在2-20字符")
//    private String name;
//
//    @Email(message = "邮箱格式无效")
//    private String email;
//}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(message = "ID不能为空")
    private Long id;

    @Size(min = 2, max = 20, message = "姓名长度需在2-20字符")
    private String name;

    @Email(message = "邮箱格式无效")
    private String email;
}