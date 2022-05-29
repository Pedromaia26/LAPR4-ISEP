RCOMP 21/22 - Sprint C - Planning document
===========================================
# Communication protocol


| Code  | Meaning  |
|---|---|
|  0 | COMMTEST - Communications test request with no other effect on the server application than the response with a code two message (ACK). This request has no data.  |
| 1  | DISCONN - End of session request. The server is supposed to respond with a code two message, afterwards both applications are expected to close the session (TCP connection). This request has no data.  |
|  2 |  ACK - Generic acknowledgment message. Used in response to requests with codes zero and one but may be used for other requests. This response has no data. |
| 100  |  ASSIGN_AGV_TO_ORDER - Requests to assign an available AGV to the first order created waiting to be prepared. |
| 101  |  ASSIGN_AGV_TO_ORDER_RESPONSE - Used in response to requests with codes 100. If an AGV is assigned to a order, client receives a message informing it. |
| 102  |  UPDATE_AGV_STATUS - Requests to update status of an AGV whenever an order is assigned to it. |
| 103  |  UPDATE_AGV_STATUS_RESPONSE - Used in response to requests with codes 102. Informs the client that the status of the AGV is updated. |
| 104  |  ADD_PRODUCT_SHOPPING_CART - Requests to add a product in the shopping cart of the logged client. |
| 105  |  ADD_PRODUCT_SHOPPING_CART_RESPONSE - Used in response to requests with codes 104. Informs the client that the product was added to his shopping cart. |
| 106  |  FREE_AGV - Requests to unlink an AGV of orders already prepared. |
| 107  |  FREE_AGV_RESPONSE - Used in response to requests with codes 106. Informs the client that AGV was unlinked from the order. |
| 108  |  UPDATE_AGV_STATUS_FREE - Requests to change the status of an AGV to free. |
| 109  |  UPDATE_AGV_STATUS_FREE_RESPONSE - Used in response to requests with codes 108. Informs the client that AGV status was updated. |