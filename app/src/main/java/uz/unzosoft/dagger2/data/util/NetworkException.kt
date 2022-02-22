package uz.unzosoft.dagger2.data.util


class ServerException(message: String) : Exception(message)

class NetworkException(message: String) : Exception(message)
class GlobalException(message: String, val statusCode: Int) :
    Exception("$message code = $statusCode")

class TokenWrongException(message: String) : Exception(message)
class NeedPassChangeException(message: String) : Exception(message)
class AppUpdateException(massage: String) : Exception(massage)
class InfoForUser(massage: String) : Exception(massage)
