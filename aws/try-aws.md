Try something on AWS
=======

## 2020/03/15

- AWS CodeStar
  - CodeStar を使って、Java Spring Webアプリケーションを作成してみた
  - 設定をポチポチ選ぶだけ、GitHub上にはリポジトリとサンプルコードが自動生成される
    - https://github.com/shionit/sample-java-codestar
    - Code Build -> Code Deploy -> Beanstalk の Code Pipeline が自動生成されて便利
  - GitHub の dependabot がすかさずライブラリの脆弱性チェックでPR投げてくれた
    - https://github.com/shionit/sample-java-codestar/pull/1
    - 偉い、賢い
  - [What Is AWS CodeStar? - AWS CodeStar](https://docs.aws.amazon.com/codestar/latest/userguide/welcome.html)
- (AWS) Swich Role
  - Switch Roleしてみた
  - 参考
    - [Swith Roleで複数のAWSアカウント間を切替える - Qiita](https://qiita.com/yoshidashingo/items/d13a9b17f111d5d91a2e)
    - [Creating a Role to Delegate Permissions to an IAM User - AWS Identity and Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html)
- AWS Chatbot (Beta)
  - Chatbot使ってみた
  - Slackを指定してChatbotの設定をやってみる
    - Slackとの認証連携を設定する
    - Chatbot用のRoleを自動生成する
    - Chatbot用のSNSトピックを設定する
      - デフォルト設定でよいので、テキトーなSNSトピックを用意する
    - Chatbot設定で指定したSlackチャンネルに `/invite @aws` でAWSアプリを招待する
  - Slack上から `@aws s3 list-buckets --region us-east-2` みたいなコマンドを投げられて凄い
  - 参考
    - [Getting Started with AWS Chatbot - AWS Chatbot](https://docs.aws.amazon.com/chatbot/latest/adminguide/getting-started.html)
    - [Setting Up AWS Chatbot - AWS Chatbot](https://docs.aws.amazon.com/chatbot/latest/adminguide/setting-up.html)
    - [Running AWS CLI Commands from Slack Channels - AWS Chatbot](https://docs.aws.amazon.com/chatbot/latest/adminguide/chatbot-cli-commands.html)
